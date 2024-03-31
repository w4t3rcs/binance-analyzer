package com.w4t3rcs.cryptoanalyzer.message.telegram.scenario;

import com.w4t3rcs.cryptoanalyzer.message.MessageBuilder;
import lombok.Data;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Data
public abstract class AbstractScenario implements Scenario {
    private final MessageBuilder<SendMessage, String, Update> messageBuilder;
}
