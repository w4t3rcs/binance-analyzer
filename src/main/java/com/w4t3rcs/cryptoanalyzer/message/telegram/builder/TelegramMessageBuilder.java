package com.w4t3rcs.cryptoanalyzer.message.telegram.builder;

import com.w4t3rcs.cryptoanalyzer.message.MessageBuilder;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class TelegramMessageBuilder implements MessageBuilder<SendMessage, String, Update> {
    @Override
    public SendMessage build(String text, Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        setChatId(sendMessage, update);
        return sendMessage;
    }

    private void setChatId(SendMessage sendMessage, Update update) {
        if (update.hasCallbackQuery()) {
            sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        } else {
            sendMessage.setChatId(update.getMessage().getChatId());
        }
    }
}