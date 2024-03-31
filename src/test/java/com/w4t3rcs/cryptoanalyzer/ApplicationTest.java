package com.w4t3rcs.cryptoanalyzer;

import com.w4t3rcs.cryptoanalyzer.entity.Interval;
import com.w4t3rcs.cryptoanalyzer.dto.KlineUrlDto;
import com.w4t3rcs.cryptoanalyzer.redis.dao.KlineAnalyzerPropertiesRepository;
import com.w4t3rcs.cryptoanalyzer.service.ExchangeCodeUrlBuilder;
import com.w4t3rcs.cryptoanalyzer.service.KlineUrlBuilder;
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
        String exchangeCode = "ETH";
        Interval interval = Interval.SECOND;
        short limit = 50;

        var testAnalyzerProperties = new KlineUrlDto(exchangeCode, interval, limit);
        analyzerPropertiesRepository.save(testAnalyzerProperties);

        System.out.println(analyzerPropertiesRepository.findById(exchangeCode).orElseThrow());
        ExchangeCodeUrlBuilder urlBuilderService = applicationContext.getBean(KlineUrlBuilder.class);
        System.out.println(urlBuilderService.getUrl(exchangeCode));
//      --------
        analyzerPropertiesRepository.deleteAll();
    }
}
