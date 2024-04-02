package com.w4t3rcs.cryptoanalyzer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class MessageConfig {
    @Bean("scenariosFromClasspath")
    public Properties scenariosFromClasspath() {
        Properties properties = new Properties();
        try {
            properties.load(new ClassPathResource("/static/scenario/eng.properties").getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }
}
