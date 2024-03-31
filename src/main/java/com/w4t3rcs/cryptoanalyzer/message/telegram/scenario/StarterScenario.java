package com.w4t3rcs.cryptoanalyzer.message.telegram.scenario;

import com.w4t3rcs.cryptoanalyzer.message.MessageBuilder;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class StarterScenario extends AbstractScenario {
    public StarterScenario(MessageBuilder<SendMessage, String, Update> messageBuilder) {
        super(messageBuilder);
    }

    @Override
    public SendMessage buildScenario(Update update) {
        if (update.hasMessage() && update.getMessage().getText().equals("/start")) {
            return getMessageBuilder().build("Welcome :)", update);
        } else {
            return null;
        }
    }
}
