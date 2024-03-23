package com.w4t3rcs.cryptoanalyzer.message.producer;

import com.w4t3rcs.cryptoanalyzer.entity.MarketChart;

public interface MessageProducer {
    void send(MarketChart message);
}
