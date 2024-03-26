package com.w4t3rcs.cryptoanalyzer.kafka.consumer;

import com.w4t3rcs.cryptoanalyzer.market.Chart;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SoutMessageConsumer implements MessageConsumer {
    @Override
//    @KafkaListener(topics = "market.chart.topic")
    public void listen(Chart message) {
        System.out.println(message);
    }
}
