package com.w4t3rcs.cryptoanalyzer.message.telegram.dto;

import com.w4t3rcs.cryptoanalyzer.binance.entity.ExchangeSymbol;
import com.w4t3rcs.cryptoanalyzer.message.telegram.scenario.Scenario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TelegramSession {
    private Scenario currentScenario;
    private ExchangeSymbol patternMatcherCode;

    public TelegramSession(Scenario currentScenario) {
        this.currentScenario = currentScenario;
    }
}
