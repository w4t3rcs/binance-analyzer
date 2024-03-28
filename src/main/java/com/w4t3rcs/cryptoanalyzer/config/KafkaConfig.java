package com.w4t3rcs.cryptoanalyzer.config;

import com.w4t3rcs.cryptoanalyzer.entity.Chart;
import com.w4t3rcs.cryptoanalyzer.message.kafka.filter.ParentFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
public class KafkaConfig {
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Chart> kafkaListenerContainerFactory(ConsumerFactory<String, Chart> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, Chart> containerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        containerFactory.setConsumerFactory(consumerFactory);
        containerFactory.setRecordFilterStrategy(new ParentFilter());
        return containerFactory;
    }
}
