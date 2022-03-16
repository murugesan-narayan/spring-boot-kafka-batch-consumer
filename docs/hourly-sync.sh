#!/usr/bin/expect -f

#############################################################################################################
# specifies the logs file for the script output, it will be appended for each run
#############################################################################################################
set now [clock seconds]
set log_date [clock format $now -format {%Y-%B}]
log_file /var/data/Persistent_Volume/test/logs/hourly-sync-$log_date-output.log


#############################################################################################################
# timeout in seconds - for each command if no response within this period will get timeout error
# The default timeout period is 10 seconds but may be set, for example to 30, by the command "set timeout 30"
# An infinite timeout may be designated by the value -1. Currently set to 1 hour.
#############################################################################################################
set timeout 3600
proc abort { } { send_log "Timeout!\n" ; exit 2 }


#############################################################################################################
# no ouput to the user console/terminal
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
# Determines the file's date and types to get from the server url
# By default, it gets yesterday's file
# It can be overridden by passing the date value in YYYY-MM-DD format to the script as argument when
# running manually, for example ./hourly-sync.sh 2022-01-28
# To get specific file type, ./hourly-sync.sh 2022-01-28 5G
# To get multiple types, ./hourly-sync.sh 2022-01-28 4G,5G
#############################################################################################################
set yday [clock scan yesterday]
set date [clock format $yday -format {%Y-%m-%d}]
set file_date $date

set arg_date [lindex $argv 0]
if { $arg_date != "" } {
  set file_date $arg_date
}

set file_type_list [list 2G 4G 5G Ciruit_core]
set arg_types [lindex $argv 1]
if { $arg_types != "" } {
  set file_type_list [split $arg_types ,]
}
send_log "Getting files \[$file_type_list\] for the Date: $file_date\n"


#############################################################################################################
# gets files for the date identified in the previous step
# files placed under /var/data/Persistent_Volume/test/ in their respective directories
#############################################################################################################
set my_url https://testweb.com/scheduled_reports/

set file_types_size [llength $file_type_list]
for {set i 0} {$i < $file_types_size} {incr i 1} {
 set file_type [lindex $file_type_list $i]
 send_log "================== Start $file_type ==========================="
 for {set h 0} {$h <= 23} {incr h} {
  set file_hour [format "%02d" $h]
  set file_name ""
  append file_name Fast_ $file_type _Hourly_ $file_date - $file_hour :00.csv
  spawn wget $my_url/$file_name --directory-prefix=/var/data/Persistent_Volume/test/$file_type/$file_date/

  expect {
   timeout {abort}
   eof {
    set output $expect_out(buffer)
   }
  }

  set log_data [exec echo $output | tr -d '\r']
  send_log "\n$log_data"
 }
 send_log "================== End $file_type =============================\n"
}

#############################################################################################################
# logs current time as end time
#############################################################################################################
set now [clock seconds]
set end_time [clock format $now -format {%Y-%m-%d %T}]
send_log "End Time: $end_time\n"
send_log "============================End=========================\n"

