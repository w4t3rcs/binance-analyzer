package com.w4t3rcs.cryptoanalyzer.message.telegram.consumer;

import com.w4t3rcs.cryptoanalyzer.message.MessageConsumer;
import com.w4t3rcs.cryptoanalyzer.message.telegram.producer.TelegramBot;
import com.w4t3rcs.cryptoanalyzer.message.telegram.scenario.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Service
public class TelegramMessageDirector implements MessageConsumer<Update> {
    private final TelegramBot telegramBot;
    private final Scenario starterScenario;

    @Autowired
    public TelegramMessageDirector(TelegramBot telegramBot, @Qualifier("starterScenario") Scenario starterScenario) {
        this.telegramBot = telegramBot;
        this.starterScenario = starterScenario;
    }

    @Override
    @RabbitListener(queues = "telegramQueue")
    @RabbitHandler
    public void listen(Update message) {
        try {
            telegramBot.executeAsync(starterScenario.buildScenario(message));
        } catch (TelegramApiException e) {
            log.error("Something went wrong with telegram scenarios controlling :(");
            throw new RuntimeException(e);
        }
    }
}
