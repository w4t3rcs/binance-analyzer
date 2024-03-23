package com.w4t3rcs.cryptoanalyzer.message.consumer;

import com.w4t3rcs.cryptoanalyzer.entity.MarketChart;

public interface MessageConsumer {
    void listen(MarketChart message);
}
