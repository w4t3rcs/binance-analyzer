package com.w4t3rcs.cryptoanalyzer.message.telegram.scenario;

import com.w4t3rcs.cryptoanalyzer.message.MessageBuilder;
import com.w4t3rcs.cryptoanalyzer.message.telegram.button.ButtonAppender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class StarterScenario extends AbstractScenario {
    private final Scenario patternMatcherStarterScenario;

    public StarterScenario(MessageBuilder<SendMessage, String, Update> messageBuilder, ButtonAppender buttonAppender,
                           @Qualifier("patternMatcherStarterScenario") Scenario patternMatcherStarterScenario) {
        super(messageBuilder, buttonAppender);
        this.patternMatcherStarterScenario = patternMatcherStarterScenario;
    }

    @Override
    public SendMessage buildScenario(Update update) {
        if (update.hasMessage() && update.getMessage().getText().equals("/start")) {
            SendMessage message = this.getMessageBuilder().build(this.getMessagesFromClasspath().getProperty("starter"), update);
            this.getButtonAppender().appendButton(message, this.getMessagesFromClasspath(), "pattern-matcher.starter.button");
            return message;
        } else {
            if (update.hasCallbackQuery() && update.getCallbackQuery().getData().equals("pattern-matcher.starter.button")) {
                return this.patternMatcherStarterScenario.buildScenario(update);
            } else {
                return null;
            }
        }
    }
}
