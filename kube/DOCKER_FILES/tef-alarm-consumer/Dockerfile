FROM ubuntu:20.04

RUN apt-get update && apt-get install -y software-properties-common && apt-get install -y openjdk-8-jdk

RUN apt-get -y install gosu

RUN groupadd --gid 5000 appuser \
    && useradd --home-dir /home/appuser --create-home --uid 5000 \
        --gid 5000 --shell /bin/sh --skel /dev/null appuser

ARG APP_PATH=/data/workspace/tef-alarm-consumer

RUN mkdir -p ${APP_PATH}/bin
RUN mkdir -p ${APP_PATH}/config

ADD tef-alarm-consumer.jar ${APP_PATH}/bin/tef-alarm-consumer.jar
ADD entrypoint.sh /data/workspace/entrypoint.sh

RUN chmod -R 755 /data/
RUN chown -R appuser:appuser /data

ENTRYPOINT ["/data/workspace/entrypoint.sh"]
CMD ["/bin/bash"]
