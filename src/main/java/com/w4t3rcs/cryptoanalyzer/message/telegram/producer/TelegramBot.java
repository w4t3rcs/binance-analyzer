package com.w4t3rcs.cryptoanalyzer.message.telegram.producer;

import com.w4t3rcs.cryptoanalyzer.message.MessageProducer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

@Getter @Setter
@Service
public class TelegramBot extends TelegramLongPollingBot implements MessageProducer<Update> {
    @Value("${app.telegram.bot.username}")
    private String botUsername;
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public TelegramBot(@Value("${app.telegram.bot.token}") String botToken, RabbitTemplate rabbitTemplate) {
        super(botToken);
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void onUpdateReceived(Update update) {
        this.send(update);
    }

    @Override
    public void send(Update message) {
        this.rabbitTemplate.convertAndSend("telegramQueue", message);
    }

    @Override
    public <T extends Serializable, Method extends BotApiMethod<T>> CompletableFuture<T> executeAsync(Method method) {
        try {
            return super.executeAsync(method);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
