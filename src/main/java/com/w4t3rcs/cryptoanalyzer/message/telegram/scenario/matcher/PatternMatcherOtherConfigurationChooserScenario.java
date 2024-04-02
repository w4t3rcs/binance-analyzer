package com.w4t3rcs.cryptoanalyzer.message.telegram.scenario.matcher;

import com.w4t3rcs.cryptoanalyzer.message.MessageBuilder;
import com.w4t3rcs.cryptoanalyzer.message.telegram.button.ButtonAppender;
import com.w4t3rcs.cryptoanalyzer.message.telegram.dto.TelegramSession;
import com.w4t3rcs.cryptoanalyzer.message.telegram.scenario.AbstractScenario;
import com.w4t3rcs.cryptoanalyzer.message.telegram.scenario.Scenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class PatternMatcherOtherConfigurationChooserScenario extends AbstractScenario {
    private final Scenario patternMatcherDefaultConfigurationScenario;
    private final Scenario patternMatcherExtendedConfigurationScenario;

    @Autowired
    public PatternMatcherOtherConfigurationChooserScenario(MessageBuilder<SendMessage, String, Update> messageBuilder, ButtonAppender buttonAppender,
                                                           @Qualifier("patternMatcherDefaultConfigurationScenario") Scenario patternMatcherDefaultConfigurationScenario,
                                                           @Qualifier("patternMatcherExtendedConfigurationScenario") Scenario patternMatcherExtendedConfigurationScenario) {
        super(messageBuilder, buttonAppender);
        this.patternMatcherDefaultConfigurationScenario = patternMatcherDefaultConfigurationScenario;
        this.patternMatcherExtendedConfigurationScenario = patternMatcherExtendedConfigurationScenario;
    }

    @Override
    public SendMessage buildScenario(Update update, TelegramSession session) {
        if (update.hasCallbackQuery()) {
            if (update.getCallbackQuery().getData().equals("pattern-matcher.configuration.other.choose.button.default")) {
                session.setCurrentScenario(patternMatcherDefaultConfigurationScenario);
                return patternMatcherDefaultConfigurationScenario.buildScenario(update, session);
            } else {
                session.setCurrentScenario(patternMatcherExtendedConfigurationScenario);
                return patternMatcherExtendedConfigurationScenario.buildScenario(update, session);
            }
        } else {
            throw new RuntimeException();
        }
    }
}
