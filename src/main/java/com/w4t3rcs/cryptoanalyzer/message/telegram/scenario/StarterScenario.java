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
public class StarterScenario extends AbstractScenario {
    private final Scenario starterChooserScenario;

    @Autowired
    public StarterScenario(MessageBuilder<SendMessage, String, Update> messageBuilder, ButtonAppender buttonAppender,
                           @Qualifier("starterChooserScenario") Scenario starterChooserScenario) {
        super(messageBuilder, buttonAppender);
        this.starterChooserScenario = starterChooserScenario;
    }

    @Override
    public SendMessage buildScenario(Update update, TelegramSession session) {
        SendMessage message = this.getMessageBuilder().build("starter", update);
        this.getButtonAppender().append(message, "starter.button.pattern-matcher");
        session.setCurrentScenario(starterChooserScenario);
        return message;
    }
}
