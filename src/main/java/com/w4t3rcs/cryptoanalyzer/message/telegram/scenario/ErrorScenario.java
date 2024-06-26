package com.w4t3rcs.cryptoanalyzer.message.telegram.scenario;

import com.w4t3rcs.cryptoanalyzer.message.MessageBuilder;
import com.w4t3rcs.cryptoanalyzer.message.telegram.button.ButtonAppender;
import com.w4t3rcs.cryptoanalyzer.message.telegram.dto.TelegramSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class ErrorScenario extends AbstractScenario{
    @Autowired
    public ErrorScenario(MessageBuilder<SendMessage, String, Update> messageBuilder, ButtonAppender buttonAppender) {
        super(messageBuilder, buttonAppender);
    }

    @Override
    public SendMessage buildScenario(Update update, TelegramSession session) {
        return this.getMessageBuilder().build("error", update);
    }
}
