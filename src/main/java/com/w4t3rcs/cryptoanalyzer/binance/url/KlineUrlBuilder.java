package com.w4t3rcs.cryptoanalyzer.binance.url;

import com.w4t3rcs.cryptoanalyzer.binance.entity.ExchangeSymbol;
import com.w4t3rcs.cryptoanalyzer.exception.PropertiesNotFoundException;
import com.w4t3rcs.cryptoanalyzer.binance.dto.KlineUrlDto;
import com.w4t3rcs.cryptoanalyzer.redis.dao.KlineAnalyzerPropertiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KlineUrlBuilder implements ExchangeSymbolUrlBuilder {
    private final KlineAnalyzerPropertiesRepository repository;

    public String getUrl(ExchangeSymbol symbol) {
        KlineUrlDto klineUrlDto = repository.findById(symbol.getCode())
                .orElseThrow(() -> new PropertiesNotFoundException("Kline analyzer properties haven't been found!"));
        return "https://api.binance.com/api/v3/klines?symbol=%s&interval=%s&limit=%d".formatted(
                klineUrlDto.getExchangeCode(),
                klineUrlDto.getInterval().getCode(),
                klineUrlDto.getLimit()
        );
    }
}
