package com.w4t3rcs.cryptoanalyzer;

import com.w4t3rcs.cryptoanalyzer.entity.MarketChart;
import com.w4t3rcs.cryptoanalyzer.message.producer.MessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(MessageProducer messageProducer) {
        return args -> {
            messageProducer.send(new MarketChart("usdt1", MarketChart.DirectionState.DOWN));
            messageProducer.send(new MarketChart("usdt2", MarketChart.DirectionState.UP));
            messageProducer.send(new MarketChart("usdt3", MarketChart.DirectionState.DOWN));
        };
    }
}
