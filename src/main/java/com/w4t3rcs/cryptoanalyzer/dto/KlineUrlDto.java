package com.w4t3rcs.cryptoanalyzer.dto;

import com.w4t3rcs.cryptoanalyzer.entity.Interval;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash(value = "KlineAnalyzerProperties")
@Data
@AllArgsConstructor @NoArgsConstructor
public class KlineUrlDto implements Serializable {
    @Id
    private String exchangeCode;
    private Interval interval;
    private short limit;
}
