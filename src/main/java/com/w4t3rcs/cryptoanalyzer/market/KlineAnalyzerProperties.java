package com.w4t3rcs.cryptoanalyzer.market;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.Duration;

@RedisHash(value = "KlineAnalyzerProperties")
@Data
@AllArgsConstructor @NoArgsConstructor
public class KlineAnalyzerProperties implements Serializable {
    @Id
    private String exchangeCode;
    private Duration interval;
    private short limit;
}
