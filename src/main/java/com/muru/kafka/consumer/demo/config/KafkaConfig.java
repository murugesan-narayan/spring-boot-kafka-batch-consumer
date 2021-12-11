package com.muru.kafka.consumer.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
@Slf4j
public class KafkaConfig {

    @Autowired
    private ConsumerFactory<String, String> consumerFactory;

    public DefaultKafkaConsumerFactory<String, String> defaultKafkaConsumerFactory() {
        Map<String, Object> config = new HashMap<>(consumerFactory.getConfigurationProperties());
        return new DefaultKafkaConsumerFactory<>(config);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListenerContainerFactory =
                new ConcurrentKafkaListenerContainerFactory<>();
        concurrentKafkaListenerContainerFactory.setConsumerFactory(defaultKafkaConsumerFactory());
        concurrentKafkaListenerContainerFactory.setBatchListener(true);
        concurrentKafkaListenerContainerFactory.setCommonErrorHandler(errorHandler());
        return concurrentKafkaListenerContainerFactory;
    }

    private DefaultErrorHandler errorHandler() {
        return new DefaultErrorHandler((record, exception) -> {
            // recover after 3 failures, with no back off - e.g. send to a dead-letter topic
            log.error("Error while batch processing...");
            }, new FixedBackOff(5000L, 2L));
    }

}
