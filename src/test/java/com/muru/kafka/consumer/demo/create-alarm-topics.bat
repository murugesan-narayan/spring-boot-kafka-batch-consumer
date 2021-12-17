@ECHO OFF
start /w /B "" CMD /c .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic AlarmSync1
start /w /B "" CMD /c .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic AlarmSync2
start /w /B "" CMD /c .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic AlarmSync3
start /w /B "" CMD /c .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic AlarmSync4
ECHO Topics command creation executed successfully.
