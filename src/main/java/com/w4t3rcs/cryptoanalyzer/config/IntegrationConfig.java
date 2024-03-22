package com.w4t3rcs.cryptoanalyzer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class IntegrationConfig {
    @Bean
    public NewTopic testTopic() {
        return TopicBuilder.name("testtopic").build();
    }
}
