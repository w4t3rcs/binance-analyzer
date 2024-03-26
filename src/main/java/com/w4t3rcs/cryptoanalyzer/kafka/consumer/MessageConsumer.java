package com.w4t3rcs.cryptoanalyzer.kafka.consumer;

import com.w4t3rcs.cryptoanalyzer.market.Chart;

public interface MessageConsumer {
    void listen(Chart message);
}
