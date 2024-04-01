package com.w4t3rcs.cryptoanalyzer.binance.dto;

import com.w4t3rcs.cryptoanalyzer.binance.entity.ExchangeSymbol;
import com.w4t3rcs.cryptoanalyzer.binance.entity.Interval;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash(value = "KlineUrlDto")
@Data
@AllArgsConstructor @NoArgsConstructor
public class KlineUrlDto implements Serializable {
    @Id
    private ExchangeSymbol symbol;
    private Interval interval;
    private short limit;
}
