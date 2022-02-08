#!/usr/bin/expect -f


#############################################################################################################
# specifies the logs file for the script output, it will be appended for each run
#############################################################################################################
log_file /var/data/Persistent_Volume/tef-daaip/logs/daaip-sftp-sync-output.log


#############################################################################################################
# timeout in seconds - for each sftp command if no response within this period will get timeout error
# The default timeout period is 10 seconds but may be set, for example to 30, by the command "set timeout 30"
# An infinite timeout may be designated by the value -1. Currently set to 1 hour.
#############################################################################################################
set timeout 3600
proc abort { } { send_log "Timeout!\n" ; exit 2 }


#############################################################################################################
# no output to the user console/terminal
#############################################################################################################
log_user 0


#############################################################################################################
# logs current time as start time
#############################################################################################################
set now [clock seconds]
set date [clock format $now -format {%Y-%m-%d}]
set time [clock format $now -format {%T}]
send_log "\n============================Start=======================\n"
send_log "Start Time: $date $time\n"


#############################################################################################################
# Determines the file's date to get from the sftp server
# By default, it gets yesterday's file
# It can be overridden by passing the date value in YYYY-MM-DD format to the script as argument when
# running manually, for example ./daaip-sftp-sync.sh 2022-01-28
#############################################################################################################
set yday [clock scan yesterday]
set date [clock format $yday -format {%Y-%m-%d}]
set file_date $date

set arg_date [lindex $argv 0]
if { $arg_date != "" } {
  set file_date $arg_date
}
send_log "Getting files for the Date: $file_date\n"


#############################################################################################################
# decodes sftp password
#############################################################################################################
set decryptor /var/data/jasypt-1.9.3/bin/decrypt.sh
set pass_secret password=somesecret
set password [exec $decryptor input=v19inpkZmZ4yHppj/1kWkI4B9KPxHzr9 $pass_secret verbose=false]


#############################################################################################################
# Connects to the sftp server server
# gets INC, WO, CRQ files for the date identified in the previous step
# files are placed under /var/data/Persistent_Volume/tef-daaip/ in their respective directories
#############################################################################################################
send_log "Connecting to sftp server..."
spawn sftp testuser@110.118.125.245

expect {
timeout {abort}
"*password: " {
 send "$password\r"
 }
}

expect {
timeout {abort}
"sftp> " {
 send_log [exec echo $expect_out(buffer) | tr -d '\r']
 send "get /home/testuser/Daily_Data_Dump-INC/INC_$file_date.csv /var/data/Persistent_Volume/tef-daaip/inc/\r"
 }
}

expect {
timeout {abort}
"sftp> " {
 send_log [exec echo $expect_out(buffer) | tr -d '\r']
 send "get /home/testuser/Daily_Data_Dump-WO/WO_$file_date.csv /var/data/Persistent_Volume/tef-daaip/wo/\r"
 }
}

expect {
timeout {abort}
"sftp> " {
 send_log [exec echo $expect_out(buffer) | tr -d '\r']
 send "get /home/testuser/Daily_Data_Dump-CRQ/crq_$file_date.csv /var/data/Persistent_Volume/tef-daaip/crq/\r"
 }
}

expect {
timeout {abort}
"sftp> " {
 send_log [exec echo $expect_out(buffer) | tr -d '\r']
 send "bye\r"
 }
}

expect {
timeout {abort}
"bye" {
 send_log [exec echo $expect_out(buffer) | tr -d '\r']
 send_log "\nDisconnected from the sftp server...\n"
 }
}


#############################################################################################################
# logs current time as end time
#############################################################################################################
set now [clock seconds]
set end_time [clock format $now -format {%Y-%m-%d %T}]
send_log "End Time: $end_time\n"
send_log "============================End=========================\n"


#############################################################################################################
# end of the script
#############################################################################################################
expect eof


