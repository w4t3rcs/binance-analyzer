package com.w4t3rcs.cryptoanalyzer.market;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class RequestBuilder {
    private String exchangeCode;
    private String interval;

    public String getUrl() {
        return String.format("https://api.binance.com/api/v3/klines?symbol=%s&interval=%s", exchangeCode, interval);
    }
}
