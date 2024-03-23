package com.w4t3rcs.cryptoanalyzer.message.consumer;

import com.w4t3rcs.cryptoanalyzer.entity.MarketChart;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TestMessageConsumer implements MessageConsumer {
    @Override
    @KafkaListener(topics = "market.chart.topic")
    public void listen(MarketChart message) {
        System.out.println(message);
    }
}
