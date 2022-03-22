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
# script usage
#############################################################################################################
proc usage {code} {
    puts [expr {$code ? "stderr" : "stdout"}] \
    "$::argv0 --date file_date --types file_types --url file_url
    --date       file_date  (Optional. Format: YYYY-MM-DD. Default: Previous day)
    --types      file_types (Optional. Valid types: 2G,4G,5G,Ciruit_core,Packet_core
                             One or more types of these with comma separated. Default: All)
    --url_type   url_type   (Optional. Either Standard or Legacy: Default: Standard)
    --help                  (Print out this message)"
    exit $code
}


#############################################################################################################
# parse args passed to the script
#############################################################################################################
array set OPTS {
    file_date  ""
    file_types ""
    url_type   ""
}

proc parseargs {argv} {
    global OPTS
    foreach {key val} $argv {
      switch -exact -- $key {
        "--date"     { set OPTS(file_date)   $val }
        "--types"    { set OPTS(file_types)  $val }
        "--url_type" { set OPTS(url_type)    $val }
        "--help"     { usage 0 }
      }
    }
}
send_log "Arguments passed: $argv\n"
parseargs $argv


#############################################################################################################
# Determines the file's date and types to get from the server url
# By default, it gets yesterday's file
# It can be overridden by passing the date value in YYYY-MM-DD format to the script as argument when
# running manually, for example
# To get for particular date ./mycomm-fastoss-hourly-sync.sh --date 2022-01-28
# To get specific file type  ./mycomm-fastoss-hourly-sync.sh --date 2022-01-28 --types 5G
# To get specific url type   ./mycomm-fastoss-hourly-sync.sh --date 2022-01-28 --types 5G --url_type Legacy
# To get multiple types      ./mycomm-fastoss-hourly-sync.sh --date 2022-01-28 --types 4G,5G
#############################################################################################################
set yday [clock scan yesterday]
set date [clock format $yday -format {%Y-%m-%d}]
set file_date $date

if { $OPTS(file_date) != "" } {
  set file_date $OPTS(file_date)
}

set file_type_list [list 2G 4G 5G Ciruit_core Packet_core]

if { $OPTS(file_types) != "" } {
  set file_type_list [split $OPTS(file_types) ,]
}

send_log "Getting files \[$file_type_list\] for the Date: $file_date\n"


#############################################################################################################
# gets MYCOMM files for the date identified in the previous step
# files placed under /var/data/Persistent_Volume/tef-mycomm/fast_oss/hourly/ in their respective directories
#############################################################################################################
set mycomm_url https://lnxv-12910.dcn.de.pri.o2.com/scheduled_reports/FastOss
set mycomm_legacy_url http://demucdnmfs01.nmc.de.pri.o2.com/PMR2/FS1/FastOss/

set file_types_size [llength $file_type_list]
for {set i 0} {$i < $file_types_size} {incr i 1} {
 set file_type [lindex $file_type_list $i]
 send_log "================== Start $file_type ==========================="
 for {set h 0} {$h <= 23} {incr h} {
  set file_hour [format "%02d" $h]
  set file_name ""
  append file_name Fast_OSS_ $file_type _Hourly_ $file_date - $file_hour :00.csv
  if { $OPTS(url_type) == "Legacy" } {
   set mycomm_url $mycomm_legacy_url
   append file_name .gz
  }
  spawn wget $mycomm_url/$file_name --directory-prefix=/var/data/Persistent_Volume/tef-mycomm/fast_oss/hourly/$file_type/$file_date/

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

