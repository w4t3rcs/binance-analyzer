package com.w4t3rcs.cryptoanalyzer.config;

import com.w4t3rcs.cryptoanalyzer.exception.SocialMediaInitializingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Slf4j
@Configuration
public class TelegramConfig {
    @Bean
    public TelegramBotsApi telegramBotsApi(LongPollingBot telegramBot) {
        try {
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(telegramBot);
            return api;
        } catch (TelegramApiException e) {
            throw new SocialMediaInitializingException(e);
        }
    }
}
