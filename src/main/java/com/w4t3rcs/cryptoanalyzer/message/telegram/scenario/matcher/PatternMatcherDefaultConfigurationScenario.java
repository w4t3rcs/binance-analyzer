package com.w4t3rcs.cryptoanalyzer.message.telegram.scenario.matcher;

import com.w4t3rcs.cryptoanalyzer.binance.dto.KlineUrlDto;
import com.w4t3rcs.cryptoanalyzer.binance.entity.Interval;
import com.w4t3rcs.cryptoanalyzer.message.MessageBuilder;
import com.w4t3rcs.cryptoanalyzer.message.telegram.button.ButtonAppender;
import com.w4t3rcs.cryptoanalyzer.message.telegram.dto.TelegramSession;
import com.w4t3rcs.cryptoanalyzer.message.telegram.scenario.AbstractScenario;
import com.w4t3rcs.cryptoanalyzer.message.telegram.scenario.Scenario;
import com.w4t3rcs.cryptoanalyzer.redis.dao.KlineAnalyzerPropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class PatternMatcherDefaultConfigurationScenario extends AbstractScenario {
    private final KlineAnalyzerPropertiesRepository propertiesRepository;
    private final Scenario patternMatcherStarterScenario;

    @Autowired
    public PatternMatcherDefaultConfigurationScenario(MessageBuilder<SendMessage, String, Update> messageBuilder, ButtonAppender buttonAppender, KlineAnalyzerPropertiesRepository propertiesRepository,
                                                      @Qualifier("patternMatcherRunnerScenario") Scenario patternMatcherStarterScenario) {
        super(messageBuilder, buttonAppender);
        this.propertiesRepository = propertiesRepository;
        this.patternMatcherStarterScenario = patternMatcherStarterScenario;
    }

    @Override
    public SendMessage buildScenario(Update update, TelegramSession session) {
        KlineUrlDto save = propertiesRepository.save(new KlineUrlDto(session.getPatternMatcherCode().getCode(), Interval.SECOND, (short) 50));
        System.out.println(save);
        session.setCurrentScenario(patternMatcherStarterScenario);
        return patternMatcherStarterScenario.buildScenario(update, session);
    }
}
