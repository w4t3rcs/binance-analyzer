package com.w4t3rcs.cryptoanalyzer.config;

import com.w4t3rcs.cryptoanalyzer.binance.entity.ExchangeSymbol;
import com.w4t3rcs.cryptoanalyzer.redis.dao.ExchangeSymbolRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Properties;

@Configuration
public class DatabaseConfig {
    @Bean
    public CommandLineRunner commandLineRunner(ExchangeSymbolRepository exchangeSymbolRepository) {
        return args -> this.saveAllExchangeSymbolsFromApi(exchangeSymbolRepository);
    }

    private void saveAllExchangeSymbolsFromApi(@NotNull ExchangeSymbolRepository exchangeSymbolRepository) {
        exchangeSymbolRepository.deleteAll();
        RestClient restClient = RestClient.create();
        ExchangeSymbol[] body = restClient.get()
                .uri("https://api.binance.com/api/v3/ticker/24hr")
                .retrieve()
                .body(ExchangeSymbol[].class);
        exchangeSymbolRepository.saveAll(Arrays.stream(Objects.requireNonNull(body))
                .filter(symbol -> symbol.getCode().endsWith("USDT"))
                .filter(symbol -> !(symbol.getCode().contains("UP") || symbol.getCode().contains("DOWN")))
                .toList());
    }
}
