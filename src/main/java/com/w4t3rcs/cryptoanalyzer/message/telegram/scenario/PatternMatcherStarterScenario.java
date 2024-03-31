package com.w4t3rcs.cryptoanalyzer.message.telegram.scenario;

import com.w4t3rcs.cryptoanalyzer.message.MessageBuilder;
import com.w4t3rcs.cryptoanalyzer.message.telegram.button.ButtonAppender;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class PatternMatcherStarterScenario extends AbstractScenario {
    public PatternMatcherStarterScenario(MessageBuilder<SendMessage, String, Update> messageBuilder, ButtonAppender buttonAppender) {
        super(messageBuilder, buttonAppender);
    }

    @Override
    public SendMessage buildScenario(Update update) {
        return this.getMessageBuilder().build(this.getMessagesFromClasspath().getProperty("pattern-matcher.starter"), update);
    }
}
