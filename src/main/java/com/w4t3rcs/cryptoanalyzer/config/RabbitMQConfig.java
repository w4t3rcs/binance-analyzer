package com.w4t3rcs.cryptoanalyzer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        DefaultClassMapper defaultClassMapper = new DefaultClassMapper();
        defaultClassMapper.setTrustedPackages("com.w4t3rcs.cryptoanalyzer.entity", "org.telegram.telegrambots.meta.api.objects");
        Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter();
        messageConverter.setClassMapper(defaultClassMapper);
        return messageConverter;
    }

    @Bean
    public Queue telegramQueue() {
        return new Queue("telegramQueue");
    }
}
