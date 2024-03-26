package com.w4t3rcs.cryptoanalyzer;

import com.w4t3rcs.cryptoanalyzer.market.KlineAnalyzerProperties;
import com.w4t3rcs.cryptoanalyzer.redis.dao.KlineAnalyzerPropertiesRepository;
import com.w4t3rcs.cryptoanalyzer.service.ExchangeCodeUrlBuilderService;
import com.w4t3rcs.cryptoanalyzer.service.KlineUrlBuilderService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.time.Duration;

@RequiredArgsConstructor
@SpringBootTest
class ApplicationTest {
    private final ApplicationContext applicationContext;

    @Test
    void test() {
        var analyzerPropertiesRepository = applicationContext.getBean(KlineAnalyzerPropertiesRepository.class);
//      --------
        String exchangeCode = "ETH";
        Duration interval = Duration.ofMinutes(1);
        short limit = 50;

        var testAnalyzerProperties = new KlineAnalyzerProperties(exchangeCode, interval, limit);
        analyzerPropertiesRepository.save(testAnalyzerProperties);

        System.out.println(analyzerPropertiesRepository.findById(exchangeCode).orElseThrow());
        ExchangeCodeUrlBuilderService urlBuilderService = applicationContext.getBean(KlineUrlBuilderService.class);
        System.out.println(urlBuilderService.getUrl(exchangeCode));
//      --------
        analyzerPropertiesRepository.deleteAll();
    }
}
