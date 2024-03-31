package com.w4t3rcs.cryptoanalyzer.message.telegram.scenario;

import com.w4t3rcs.cryptoanalyzer.message.MessageBuilder;
import com.w4t3rcs.cryptoanalyzer.message.telegram.button.ButtonAppender;
import lombok.Data;
import org.springframework.core.io.ClassPathResource;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.util.Properties;

@Data
public abstract class AbstractScenario implements Scenario {
    private final MessageBuilder<SendMessage, String, Update> messageBuilder;
    private final ButtonAppender buttonAppender;

    public AbstractScenario(MessageBuilder<SendMessage, String, Update> messageBuilder, ButtonAppender buttonAppender) {
        this.messageBuilder = messageBuilder;
        this.buttonAppender = buttonAppender;
    }

    protected final Properties getMessagesFromClasspath() {
        Properties properties = new Properties();
        try {
            properties.load(new ClassPathResource("/static/scenario/eng.properties").getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }
}
