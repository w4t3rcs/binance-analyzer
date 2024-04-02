package com.w4t3rcs.cryptoanalyzer.message.kafka.director;

import com.w4t3rcs.cryptoanalyzer.binance.url.ExchangeCodeUrlBuilder;
import com.w4t3rcs.cryptoanalyzer.message.BinanceMessageDirector;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KafkaMessageDirector implements BinanceMessageDirector {
    private final ExchangeCodeUrlBuilder codeUrlBuilder;

    @Override
    @Scheduled(fixedDelay = 1000)
    public void fetchKlineDataFromApi() {

    }
}
