package com.w4t3rcs.cryptoanalyzer.message.telegram.scenario;

import com.w4t3rcs.cryptoanalyzer.binance.entity.ExchangeSymbol;
import com.w4t3rcs.cryptoanalyzer.message.MessageBuilder;
import com.w4t3rcs.cryptoanalyzer.message.telegram.button.ButtonAppender;
import com.w4t3rcs.cryptoanalyzer.redis.dao.ExchangeSymbolRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;
import java.util.Properties;

@Component
public class PatternMatcherStarterScenario extends AbstractScenario {
    private int currentPageStart = 0;
    private final ExchangeSymbolRepository exchangeSymbolRepository;

    public PatternMatcherStarterScenario(MessageBuilder<SendMessage, String, Update> messageBuilder, ButtonAppender buttonAppender, ExchangeSymbolRepository exchangeSymbolRepository) {
        super(messageBuilder, buttonAppender);
        this.exchangeSymbolRepository = exchangeSymbolRepository;
    }

    @Override
    public SendMessage buildScenario(Update update) {
        if (update.getCallbackQuery().getData().contains("pattern-matcher.exchange.button")) {
            return null;
        } else {
            SendMessage message = this.getMessageBuilder().build(this.getMessagesFromClasspath().getProperty("pattern-matcher.starter"), update);
            this.getButtonAppender().append(message, this.getExchangesButtonNames(), this.getExchangeButtonIds());
            return message;
        }
    }

    public String[] getExchangeButtonIds() {
        final String buttonPrefix = "pattern-matcher.exchange.";
        final String buttonSuffix = ".button";
        return this.getExchangeCodes().stream()
                .map(code -> buttonPrefix + code.toLowerCase() + buttonSuffix)
                .toArray(String[]::new);
    }

    public Properties getExchangesButtonNames() {
        final String buttonPrefix = "pattern-matcher.exchange.";
        final String buttonSuffix = ".button";
        final Properties buttonNames = new Properties();
        this.getExchangeCodes().forEach(exchange -> buttonNames.put(buttonPrefix + exchange.toLowerCase() + buttonSuffix, exchange));
        return buttonNames;
    }

    public List<String> getExchangeCodes() {
        List<String> list = exchangeSymbolRepository.findAll(PageRequest.of(currentPageStart, 25, Sort.by("askPrice").descending()))
                .stream()
                .map(ExchangeSymbol::getCode)
                .toList();
        // TODO: 01.04.2024  
        currentPageStart += 25;
        return list;
    }
}
