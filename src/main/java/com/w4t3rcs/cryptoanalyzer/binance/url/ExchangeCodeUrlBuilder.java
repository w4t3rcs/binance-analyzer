package com.w4t3rcs.cryptoanalyzer.binance.url;

import com.w4t3rcs.cryptoanalyzer.binance.entity.ExchangeSymbol;

public interface ExchangeCodeUrlBuilder {
    String getUrl(ExchangeSymbol symbol);
}
