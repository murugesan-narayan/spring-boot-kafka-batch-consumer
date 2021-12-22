package com.muru.kafka.consumer.demo.config;

import com.muru.kafka.consumer.demo.model.AlarmMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.*;
import org.springframework.util.backoff.FixedBackOff;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.util.backoff.FixedBackOff.UNLIMITED_ATTEMPTS;

@EnableKafka
@Configuration
@Slf4j
public class KafkaConfig {

    @Autowired
    private ConsumerFactory<String, AlarmMessage> consumerFactory;

    public DefaultKafkaConsumerFactory<String, AlarmMessage> defaultKafkaConsumerFactory() {
        Map<String, Object> config = new HashMap<>(consumerFactory.getConfigurationProperties());
        return new DefaultKafkaConsumerFactory<>(config);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, AlarmMessage> concurrentKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, AlarmMessage> concurrentKafkaListenerContainerFactory =
                new ConcurrentKafkaListenerContainerFactory<>();
        concurrentKafkaListenerContainerFactory.setConsumerFactory(defaultKafkaConsumerFactory());
        return concurrentKafkaListenerContainerFactory;
    }

    @Bean
    public CommonErrorHandler errorHandler() {
        return new DefaultErrorHandler(
                new FixedBackOff(60000L, UNLIMITED_ATTEMPTS));
    }
}
