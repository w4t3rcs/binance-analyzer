package com.w4t3rcs.cryptoanalyzer.binance.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeInfo {
    private List<ExchangeSymbol> symbols;
}
