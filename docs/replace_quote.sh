#!/bin/bash
exec 1>>output-$0.log 2>&1

if [ -z "$1" ]
then
  echo "Date argument should not be empty. Please run like $0 YYYY_MM_DD"
  exit 0
fi
echo "Script called with $0 $@"

date=$(date)
echo "Start time: $date"

proc_date=$1
target_dir=$2
if [ -z "$2" ]
then
  target_dir=$proc_date
fi
fixed_files_dir=/var/data/quote_issue/fixed_files/$target_dir/
proc_dir=/var/data/quote_issue/$proc_date
echo "Cleaning up previous files in $proc_dir"
rm -rf $proc_dir
#rm -rf $fixed_files_dir

echo "Creating dir $proc_dir"
mkdir -p $proc_dir
mkdir -p $fixed_files_dir

echo "Start processing files.."
count=0
for R_FILE in /var/data/AlarmArchival/AlarmData_$proc_date*.csv
do
   echo "Processing $R_FILE"
   cp $R_FILE $proc_dir
   temp_file=$proc_dir/$(basename $R_FILE)
   sed -Ei "s/(^[^']*)'+([^']*)$/\1 \2/g" $temp_file
   sed -Ei ":a ; $!N ; s/\n'([^a-z])/ \1/ ; ta ; P ; D" $temp_file
   sed -Ei ":a ; $!N ; s/\n([^'])/ \1/ ; ta ; P ; D" $temp_file
   sed -Ei "/^'delete'/! s/([^,])([']+)([^,]|,[^'])/\1 \3/g" $temp_file
   sed -Ei "/^'delete'/! s/([^,])([']+)([^,]|,[^'])/\1 \3/g" $temp_file
   ((count=count+1))
done
echo "Processed files count: $count for the date $proc_date"

echo "Moving all fixed files to $fixed_files_dir"
mv $proc_dir/*.csv $fixed_files_dir

date=$(date)
echo "End time: $date"

