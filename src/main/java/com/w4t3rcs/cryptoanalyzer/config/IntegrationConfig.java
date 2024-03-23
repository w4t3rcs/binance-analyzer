package com.w4t3rcs.cryptoanalyzer.config;

import com.w4t3rcs.cryptoanalyzer.entity.MarketChart;
import com.w4t3rcs.cryptoanalyzer.message.producer.MessageProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.http.dsl.Http;

@Configuration
public class IntegrationConfig {
    @Bean
    public IntegrationFlow httpInputFlow() {
        return IntegrationFlow.from(Http.inboundGateway("/"))
                .channel("httpInputChannel")
                .log()
                .get();
    }

    @Bean
    public IntegrationFlow kafkaOutputFlow(MessageProducer messageProducer) {
        return IntegrationFlow.from("httpInputChannel")
                .handle((message) -> messageProducer.send((MarketChart) message.getPayload()))
                .channel("kafkaOutputChannel")
                .log()
                .get();
    }
}
