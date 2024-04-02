package com.w4t3rcs.cryptoanalyzer.message.telegram.scenario.matcher;

import com.w4t3rcs.cryptoanalyzer.message.MessageBuilder;
import com.w4t3rcs.cryptoanalyzer.message.telegram.button.ButtonAppender;
import com.w4t3rcs.cryptoanalyzer.message.telegram.dto.TelegramSession;
import com.w4t3rcs.cryptoanalyzer.message.telegram.scenario.AbstractScenario;
import com.w4t3rcs.cryptoanalyzer.redis.dao.KlineAnalyzerPropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class PatternMatcherExtendedConfigurationScenario extends AbstractScenario {
    private final KlineAnalyzerPropertiesRepository propertiesRepository;

    @Autowired
    public PatternMatcherExtendedConfigurationScenario(MessageBuilder<SendMessage, String, Update> messageBuilder, ButtonAppender buttonAppender, KlineAnalyzerPropertiesRepository propertiesRepository) {
        super(messageBuilder, buttonAppender);
        this.propertiesRepository = propertiesRepository;
    }

    @Override
    public SendMessage buildScenario(Update update, TelegramSession session) {
        return null;
    }
}
