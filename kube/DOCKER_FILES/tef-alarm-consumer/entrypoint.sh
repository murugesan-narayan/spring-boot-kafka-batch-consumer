#!/bin/bash
set -e
gosu appuser java -jar /data/workspace/tef-alarm-consumer/bin/tef-alarm-consumer.jar --spring.config.location=file:/data/workspace/tef-alarm-consumer/config/ --logging.config=file:/data/workspace/tef-alarm-consumer/config/logback.xml
exec /bin/bash
