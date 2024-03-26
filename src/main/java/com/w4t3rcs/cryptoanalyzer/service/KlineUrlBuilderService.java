package com.w4t3rcs.cryptoanalyzer.service;

import com.w4t3rcs.cryptoanalyzer.exception.PropertiesNotFoundException;
import com.w4t3rcs.cryptoanalyzer.market.KlineAnalyzerProperties;
import com.w4t3rcs.cryptoanalyzer.redis.dao.KlineAnalyzerPropertiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class KlineUrlBuilderService implements ExchangeCodeUrlBuilderService {
    private final KlineAnalyzerPropertiesRepository repository;

    public String getUrl(String exchangeCode) {
        KlineAnalyzerProperties analyzerProperties = repository.findById(exchangeCode).orElseThrow(() -> new PropertiesNotFoundException("Kline analyzer properties haven't been found!"));
        return "https://api.binance.com/api/v3/klines?symbol=%s&interval=%s&limit=%d".formatted(
                analyzerProperties.getExchangeCode() + "BTC",
                analyzerProperties.getInterval().getSeconds() / 60 + "m",
                analyzerProperties.getLimit()
        );
    }
}
