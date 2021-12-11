# spring-boot-kafka-batch-consumer
    It demonstrates kafka batch consumer with spring boot framework.

### Kafka
    Ensure that you have proper kafka local setup. If required enable ssl.

### Push Message
    To generate test message file refer TestDataCreatorUtils.java
    .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic TestTopic < test-data-2mb.txt

### Run
    Run the SpringBootKafkaBatchConsumerDemoApplication.java
    Ensure heap memory if you are processing too much data.

### Refs
    https://docs.confluent.io/platform/current/installation/configuration/consumer-configs.html
    http://devdoc.net/javaweb/spring/spring-kafka-docs-2.2.3/reference/htmlsingle/
	https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html
	https://codingnconcepts.com/spring-boot/configure-kafka-producer-and-consumer/
	https://docs.confluent.io/platform/current/installation/configuration/consumer-configs.html
