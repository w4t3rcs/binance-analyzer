package com.w4t3rcs.cryptoanalyzer;

import com.w4t3rcs.cryptoanalyzer.market.Chart;
import com.w4t3rcs.cryptoanalyzer.kafka.producer.MessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(MessageProducer messageProducer) {
        return args -> {
            List<Chart> charts = List.of(
                    new Chart("etherium", Chart.DirectionState.UP),
                    new Chart("pepe", Chart.DirectionState.DOWN),
                    new Chart("bitcoin", Chart.DirectionState.UP)
            );

            charts.forEach(messageProducer::send);
        };
    }
}
