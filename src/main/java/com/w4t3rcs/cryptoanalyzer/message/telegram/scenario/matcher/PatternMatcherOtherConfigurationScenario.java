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
public class PatternMatcherOtherConfigurationScenario extends AbstractScenario {
    private final Scenario patternMatcherOtherConfigurationChooserScenario;

    @Autowired
    public PatternMatcherOtherConfigurationScenario(MessageBuilder<SendMessage, String, Update> messageBuilder, ButtonAppender buttonAppender,
                                                    @Qualifier("patternMatcherOtherConfigurationChooserScenario") Scenario patternMatcherOtherConfigurationChooserScenario) {
        super(messageBuilder, buttonAppender);
        this.patternMatcherOtherConfigurationChooserScenario = patternMatcherOtherConfigurationChooserScenario;
    }

    @Override
    public SendMessage buildScenario(Update update, TelegramSession session) {
        SendMessage message = this.getMessageBuilder().build("pattern-matcher.configuration.other.choose", update);
        this.getButtonAppender().append(message, "pattern-matcher.configuration.other.choose.button.default", "pattern-matcher.configuration.other.choose.button.extended");
        session.setCurrentScenario(patternMatcherOtherConfigurationChooserScenario);
        return message;
    }
}
