package com.w4t3rcs.cryptoanalyzer.message.telegram.scenario.matcher;

import com.w4t3rcs.cryptoanalyzer.binance.entity.Chart;
import com.w4t3rcs.cryptoanalyzer.message.MessageBuilder;
import com.w4t3rcs.cryptoanalyzer.message.MessageConsumer;
import com.w4t3rcs.cryptoanalyzer.message.telegram.button.ButtonAppender;
import com.w4t3rcs.cryptoanalyzer.message.telegram.dto.TelegramSession;
import com.w4t3rcs.cryptoanalyzer.message.telegram.scenario.AbstractScenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class PatternMatcherRunnerScenario extends AbstractScenario implements MessageConsumer<Chart> {
    @Autowired
    public PatternMatcherRunnerScenario(MessageBuilder<SendMessage, String, Update> messageBuilder, ButtonAppender buttonAppender) {
        super(messageBuilder, buttonAppender);
    }

    @Override
    public SendMessage buildScenario(Update update, TelegramSession session) {
        return null;
    }

    @Override
    @KafkaListener(topics = "binance.chart.topic")
    public void listen(Chart message) {

    }
}
