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

@Slf4j
@Service
public class TelegramMessageDirector implements MessageConsumer<Update> {
    private final TelegramBot telegramBot;
    private final Scenario starterScenario;
    private final Scenario errorScenario;

    @Autowired
    public TelegramMessageDirector(TelegramBot telegramBot, @Qualifier("starterScenario") Scenario starterScenario,
                                   @Qualifier("errorScenario") Scenario errorScenario) {
        this.telegramBot = telegramBot;
        this.starterScenario = starterScenario;
        this.errorScenario = errorScenario;
    }

    @Override
    @RabbitListener(queues = "telegramQueue")
    @RabbitHandler
    public void listen(Update message) {
        try {
            telegramBot.executeAsync(starterScenario.buildScenario(message));
        } catch (Exception e) {
            log.warn("Something went wrong with telegram scenarios controlling :(");
            telegramBot.executeAsync(errorScenario.buildScenario(message));
        }
    }
}
