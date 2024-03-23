package com.w4t3rcs.cryptoanalyzer.message.producer;

import com.w4t3rcs.cryptoanalyzer.entity.MarketChart;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TestProducerService implements MessageProducer {
    private final KafkaTemplate<String, MarketChart> kafkaTemplate;

    @Override
    public void send(MarketChart message) {
        kafkaTemplate.sendDefault(message);
    }
}
