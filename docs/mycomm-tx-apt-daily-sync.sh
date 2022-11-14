#!/bin/bash
######################################################################################
# This script pulls tx-apt files [ml6352, mltn, pack4, rtn] form my-comm server url
#
# Parms:
#    1: date in YYYYMMDD. It is optional. Default previous day
#
# To run manually
# ./mycomm-tx-apt-daily-sync.sh 20221031
######################################################################################


## logging
log_dir=/var/data/Persistent_Volume/tef-mycomm/logs/tx-apt/
log_month=$(date '+%Y-%B')
exec 1>>${log_dir}${log_month}-output.log 2>&1


## date
download_date="$1"
if [ -z "$1" ]
then
  download_date=$(date '+%Y%m%d')
fi
echo -e "\n\n\n==============================================Start================================================="
echo Downloading my-comm tx-apt files for ${download_date}


## declaration
base_dir=/var/data/Persistent_Volume/tef-mycomm/tx_apt/
mycomm_url=https://test.com/scheduled_reports/Transport/APT/15min_output/


## downloading files
for file_type in ml6352 mltn pack4 rtn
do
  file_dir=${base_dir}${file_type}/
  mkdir -p ${file_dir}
  cd ${file_dir}
  echo $PWD
  for file_part in part1 part2 part3 part4
  do
    file_name=APT_Transmission_15min_${file_type}_${file_part}.${download_date}.csv
    wget --spider -nv ${mycomm_url}${file_name} && wget --progress=bar:force:noscroll ${mycomm_url}${file_name} -O ${file_name}
  done
done

echo -e "\n==================================================End============================================="
