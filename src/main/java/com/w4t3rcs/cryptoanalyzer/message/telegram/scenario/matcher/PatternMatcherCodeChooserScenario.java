package com.w4t3rcs.cryptoanalyzer.message.telegram.scenario.matcher;

import com.w4t3rcs.cryptoanalyzer.message.MessageBuilder;
import com.w4t3rcs.cryptoanalyzer.message.telegram.button.ButtonAppender;
import com.w4t3rcs.cryptoanalyzer.message.telegram.dto.TelegramSession;
import com.w4t3rcs.cryptoanalyzer.message.telegram.scenario.AbstractScenario;
import com.w4t3rcs.cryptoanalyzer.redis.dao.ExchangeSymbolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class PatternMatcherCodeChooserScenario extends AbstractScenario {
    private final ExchangeSymbolRepository exchangeSymbolRepository;
    private final PatternMatcherOtherConfigurationScenario patternMatcherOtherConfigurationScenario;

    @Autowired
    public PatternMatcherCodeChooserScenario(MessageBuilder<SendMessage, String, Update> messageBuilder, ButtonAppender buttonAppender,
                                             ExchangeSymbolRepository exchangeSymbolRepository, @Qualifier("patternMatcherOtherConfigurationScenario") PatternMatcherOtherConfigurationScenario patternMatcherOtherConfigurationScenario) {
        super(messageBuilder, buttonAppender);
        this.exchangeSymbolRepository = exchangeSymbolRepository;
        this.patternMatcherOtherConfigurationScenario = patternMatcherOtherConfigurationScenario;
    }

    @Override
    public SendMessage buildScenario(Update update, TelegramSession session) {
        if (update.hasMessage()) {
            String textFromMessage = update.getMessage().getText();
            if (this.exchangeSymbolRepository.existsById(textFromMessage)
                    || this.exchangeSymbolRepository.existsById(textFromMessage + "USDT")) {
                if (textFromMessage.endsWith("USDT")) session.setPatternMatcherCode(exchangeSymbolRepository.findById(textFromMessage).orElseThrow());
                else session.setPatternMatcherCode(exchangeSymbolRepository.findById(textFromMessage + "USDT").orElseThrow());
                session.setCurrentScenario(patternMatcherOtherConfigurationScenario);
                return patternMatcherOtherConfigurationScenario.buildScenario(update, session);
            } else {
                throw new RuntimeException();
            }
        } else {
            session.setCurrentScenario(this);
            return this.getMessageBuilder().build("pattern-matcher.configuration.code", update);
        }
    }
}
