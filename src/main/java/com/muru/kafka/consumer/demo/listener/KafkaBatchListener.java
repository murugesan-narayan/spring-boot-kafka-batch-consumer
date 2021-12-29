package com.muru.kafka.consumer.demo.listener;

import com.muru.kafka.consumer.demo.model.AlarmMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Slf4j
public class KafkaBatchListener {
    @Value("${consumer.storage-path}")
    private String storagePath;

    @KafkaListener(topics = "#{'${consumer.topic-names}'.split(',')}")
    public void receive(List<AlarmMessage> data,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) throws Exception {
        log.info("-------------------start of batch receive-------------------");
        log.info("Batch Size: {}", data.size());
        writeToFile(data);
        log.info("-------------------end of batch receive-------------------");
    }

    private void writeToFile(List<AlarmMessage> alarmData) throws Exception {
        try {
            String formattedTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("uuuu_MM_dd'T'hh_mm_ss_"));
            String formattedDate = formattedTime.substring(0, formattedTime.indexOf('T'));
            String formattedFileName = "AlarmData_"+formattedTime+"_"+UUID.randomUUID()+".csv";
            Path file = Path.of(storagePath, formattedFileName);
            Path dir = Path.of(storagePath, formattedDate);
            if(!dir.toFile().exists()) {
                Files.createDirectory(dir);
            }
            Path createdFile = Files.createFile(file);
            List<String> data = Stream.concat(
                    Stream.of(AlarmMessage.getHeader()),
                    alarmData.stream().map(AlarmMessage::toString))
                    .collect(Collectors.toList());
            Files.write(createdFile, data, StandardCharsets.UTF_8);
            log.info("File is written in path: {}", file.toAbsolutePath());
        } catch (Exception e) {
            log.error("Exception thrown: ", e);
            throw e;
        }
    }
}
