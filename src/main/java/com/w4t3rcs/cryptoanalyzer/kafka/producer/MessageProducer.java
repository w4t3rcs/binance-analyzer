package com.w4t3rcs.cryptoanalyzer.kafka.producer;

import com.w4t3rcs.cryptoanalyzer.market.Chart;

public interface MessageProducer {
    void send(Chart message);
}
