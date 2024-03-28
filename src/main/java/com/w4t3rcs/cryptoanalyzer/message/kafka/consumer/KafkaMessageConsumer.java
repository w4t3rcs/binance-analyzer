package com.w4t3rcs.cryptoanalyzer.message.kafka.consumer;

import com.w4t3rcs.cryptoanalyzer.entity.Chart;
import com.w4t3rcs.cryptoanalyzer.message.MessageConsumer;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageConsumer implements MessageConsumer<Chart> {
    @Override
//    @KafkaListener(topics = "market.chart.topic")
    public void listen(Chart message) {
        System.out.println(message);
    }
}
