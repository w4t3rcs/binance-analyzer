package com.w4t3rcs.cryptoanalyzer;

import com.w4t3rcs.cryptoanalyzer.binance.entity.ExchangeSymbol;
import com.w4t3rcs.cryptoanalyzer.binance.entity.Interval;
import com.w4t3rcs.cryptoanalyzer.binance.dto.KlineUrlDto;
import com.w4t3rcs.cryptoanalyzer.redis.dao.KlineAnalyzerPropertiesRepository;
import com.w4t3rcs.cryptoanalyzer.binance.url.ExchangeSymbolUrlBuilder;
import com.w4t3rcs.cryptoanalyzer.binance.url.KlineUrlBuilder;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@RequiredArgsConstructor
@SpringBootTest
class ApplicationTest {
    private final ApplicationContext applicationContext;

    @Test
    void test() {
        var analyzerPropertiesRepository = applicationContext.getBean(KlineAnalyzerPropertiesRepository.class);
//      --------
        ExchangeSymbol symbol = new ExchangeSymbol();
        symbol.setCode("ETHBTC");
        Interval interval = Interval.SECOND;
        short limit = 50;

        var testAnalyzerProperties = new KlineUrlDto(symbol, interval, limit);
        analyzerPropertiesRepository.save(testAnalyzerProperties);

        System.out.println(analyzerPropertiesRepository.findById(symbol).orElseThrow());
        ExchangeSymbolUrlBuilder urlBuilderService = applicationContext.getBean(KlineUrlBuilder.class);
        System.out.println(urlBuilderService.getUrl(symbol));
//      --------
        analyzerPropertiesRepository.deleteAll();
    }
}
