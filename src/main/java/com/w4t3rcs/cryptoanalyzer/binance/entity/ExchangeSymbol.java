package com.w4t3rcs.cryptoanalyzer.binance.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "ExchangeSymbol")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeSymbol {
    @Id
    @JsonProperty("symbol")
    private String code;
    private double askPrice;
}
