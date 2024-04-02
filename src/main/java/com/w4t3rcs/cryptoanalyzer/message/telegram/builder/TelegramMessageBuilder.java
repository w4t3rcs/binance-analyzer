package com.w4t3rcs.cryptoanalyzer.message.telegram.builder;

import com.w4t3rcs.cryptoanalyzer.message.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Properties;

@Service
public class TelegramMessageBuilder implements MessageBuilder<SendMessage, String, Update> {
    private final Properties messagesFromClasspath;

    @Autowired
    public TelegramMessageBuilder(@Qualifier("scenariosFromClasspath") Properties messagesFromClasspath) {
        this.messagesFromClasspath = messagesFromClasspath;
    }

    @Override
    public SendMessage build(String text, Update update) {
        SendMessage sendMessage = new SendMessage();
        setText(sendMessage, text);
        setChatId(sendMessage, update);
        return sendMessage;
    }

    private void setText(SendMessage sendMessage, String text) {
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        if (messagesFromClasspath.containsKey(text)) {
            sendMessage.setText(messagesFromClasspath.getProperty(text));
        } else {
            sendMessage.setText(text);
        }
    }

    private void setChatId(SendMessage sendMessage, Update update) {
        if (update.hasCallbackQuery()) {
            sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
        } else if (update.hasMessage()) {
            sendMessage.setChatId(update.getMessage().getChatId());
        }
    }
}