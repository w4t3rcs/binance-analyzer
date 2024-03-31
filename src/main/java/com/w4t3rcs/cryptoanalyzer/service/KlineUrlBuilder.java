package com.w4t3rcs.cryptoanalyzer.service;

import com.w4t3rcs.cryptoanalyzer.exception.PropertiesNotFoundException;
import com.w4t3rcs.cryptoanalyzer.dto.KlineUrlDto;
import com.w4t3rcs.cryptoanalyzer.redis.dao.KlineAnalyzerPropertiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KlineUrlBuilder implements ExchangeCodeUrlBuilder {
    private final KlineAnalyzerPropertiesRepository repository;

    public String getUrl(String exchangeCode) {
        KlineUrlDto analyzerProperties = repository.findById(exchangeCode)
                .orElseThrow(() -> new PropertiesNotFoundException("Kline analyzer properties haven't been found!"));
        return "https://api.binance.com/api/v3/klines?symbol=%s&interval=%s&limit=%d".formatted(
                analyzerProperties.getExchangeCode() + "BTC",
                analyzerProperties.getInterval().getCode(),
                analyzerProperties.getLimit()
        );
    }
}
