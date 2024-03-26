package com.w4t3rcs.cryptoanalyzer.kafka.producer;

import com.w4t3rcs.cryptoanalyzer.market.Chart;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultMarketChartProducer implements MessageProducer {
    private final KafkaTemplate<String, Chart> kafkaTemplate;

    @Override
    public void send(Chart message) {
        kafkaTemplate.send("market.chart.topic", message);
    }
}
