package com.w4t3rcs.cryptoanalyzer.message.telegram;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Getter @Setter
@Component
public class TelegramBot extends TelegramLongPollingBot {
    @Value("${app.telegram.bot.username}")
    private String botUsername;

    public TelegramBot(@Value("${app.telegram.bot.token}") String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            this.execute(SendMessage.builder()
                    .chatId(update.getMessage().getChatId())
                    .text("Hello")
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
