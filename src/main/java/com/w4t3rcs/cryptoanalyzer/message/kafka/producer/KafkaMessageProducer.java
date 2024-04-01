package com.w4t3rcs.cryptoanalyzer.message.kafka.producer;

import com.w4t3rcs.cryptoanalyzer.binance.entity.Chart;
import com.w4t3rcs.cryptoanalyzer.message.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KafkaMessageProducer implements MessageProducer<Chart> {
    private final KafkaTemplate<String, Chart> kafkaTemplate;

    @Override
    public void send(Chart message) {
        kafkaTemplate.send("market.chart.topic", message);
    }
}
