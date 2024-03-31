package com.w4t3rcs.cryptoanalyzer.message.telegram.builder;

import com.w4t3rcs.cryptoanalyzer.message.MessageBuilder;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class TelegramTextMessageBuilder implements MessageBuilder<SendMessage, String, Update> {
    @Override
    public SendMessage build(String text, Update update) {
        return SendMessage.builder()
                .text(text)
                .chatId(update.getMessage().getChatId())
                .parseMode(ParseMode.MARKDOWN)
                .build();
    }
}
