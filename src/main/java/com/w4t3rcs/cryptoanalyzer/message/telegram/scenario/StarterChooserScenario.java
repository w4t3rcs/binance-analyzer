package com.w4t3rcs.cryptoanalyzer.message.telegram.scenario;

import com.w4t3rcs.cryptoanalyzer.message.MessageBuilder;
import com.w4t3rcs.cryptoanalyzer.message.telegram.button.ButtonAppender;
import com.w4t3rcs.cryptoanalyzer.message.telegram.dto.TelegramSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class StarterChooserScenario extends AbstractScenario {
    private final Scenario patternMatcherStarterScenario;

    @Autowired
    public StarterChooserScenario(MessageBuilder<SendMessage, String, Update> messageBuilder, ButtonAppender buttonAppender,
                                  @Qualifier("patternMatcherCodeChooserScenario") Scenario patternMatcherStarterScenario) {
        super(messageBuilder, buttonAppender);
        this.patternMatcherStarterScenario = patternMatcherStarterScenario;
    }

    @Override
    public SendMessage buildScenario(Update update, TelegramSession session) {
        if (update.hasCallbackQuery() && update.getCallbackQuery().getData().equals("starter.button.pattern-matcher")) {
            session.setCurrentScenario(patternMatcherStarterScenario);
            return this.patternMatcherStarterScenario.buildScenario(update, session);
        } else {
            throw new RuntimeException();
        }
    }
}
