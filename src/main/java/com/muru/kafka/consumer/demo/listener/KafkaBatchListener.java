package com.muru.kafka.consumer.demo.listener;

import com.muru.kafka.consumer.demo.exception.BatchProcessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class KafkaBatchListener {
    @Value("${consumer.storage-path}")
    private String storagePath;

    @KafkaListener(topics = "#{'${consumer.topic-names}'.split(',')}")
    public void receive(List<String> data,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("-------------------start of batch receive-------------------");
        log.info("Batch Size: {}", data.size());
/*        for (int i = 0; i < data.size(); i++) {
            //byte[] bytes = data.get(i);
            String msg = data.get(i);
            log.info("Received message='{}' with partition-offset='{}'", msg,
                    partitions.get(i) + "-" + offsets.get(i));
            // handle message
        }*/
        writeToFile(data);
        log.info("-------------------end of batch receive-------------------");
    }

    private void writeToFile(List<String> data) {
        String formattedTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("uuuu_MM_dd_hh_mm_ss_"));
        Path file = Path.of(storagePath, formattedTime+UUID.randomUUID()+".txt");
        try {
            Path createdFile = Files.createFile(file);
            Files.write(createdFile, data, StandardCharsets.UTF_8);
            log.info("File is written in path: {}", file.toAbsolutePath());
        } catch (IOException e) {
            throw new BatchProcessException("Unable to write file " + file.toAbsolutePath());
        }
    }
}
