@ECHO OFF
start /w /B "" CMD /c .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic AlarmSync1 < C:\Muru\source\myapp\remote\spring-boot-kafka-batch-consumer\target\test-data-3min.txt
start /w /B "" CMD /c .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic AlarmSync2 < C:\Muru\source\myapp\remote\spring-boot-kafka-batch-consumer\target\test-data-3min.txt
start /w /B "" CMD /c .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic AlarmSync3 < C:\Muru\source\myapp\remote\spring-boot-kafka-batch-consumer\target\test-data-3min.txt
start /w /B "" CMD /c .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic AlarmSync4 < C:\Muru\source\myapp\remote\spring-boot-kafka-batch-consumer\target\test-data-3min.txt
ECHO 3min files sent successfully.
start /w /B "" CMD /c .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic AlarmSync1 < C:\Muru\source\myapp\remote\spring-boot-kafka-batch-consumer\target\test-data-1min.txt
start /w /B "" CMD /c .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic AlarmSync2 < C:\Muru\source\myapp\remote\spring-boot-kafka-batch-consumer\target\test-data-1min.txt
start /w /B "" CMD /c .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic AlarmSync3 < C:\Muru\source\myapp\remote\spring-boot-kafka-batch-consumer\target\test-data-1min.txt
start /w /B "" CMD /c .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic AlarmSync4 < C:\Muru\source\myapp\remote\spring-boot-kafka-batch-consumer\target\test-data-1min.txt
ECHO 1min files sent successfully.
