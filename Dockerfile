FROM openjdk:17

ARG BUILD_JAR_FILE
ARG APP_NAME
ARG APP_PATH=/user/share/${APP_NAME}
ENV APP_JAR=${APP_PATH}/bin/$APP_NAME.jar
ARG KAFKA_CLIENT_TRUSTSTORE

RUN mkdir -p ${APP_PATH}/bin
RUN mkdir -p ${APP_PATH}/client-certs

ADD ${BUILD_JAR_FILE} ${APP_JAR}
ADD ${KAFKA_CLIENT_TRUSTSTORE} ${APP_PATH}/client-certs/kafka.client.truststore.jks

ENTRYPOINT java -jar $APP_JAR
