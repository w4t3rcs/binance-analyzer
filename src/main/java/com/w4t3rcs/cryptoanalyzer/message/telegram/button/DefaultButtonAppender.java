package com.w4t3rcs.cryptoanalyzer.message.telegram.button;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.*;

@Service
public class DefaultButtonAppender implements ButtonAppender {
    private final Properties messagesFromClasspath;

    @Autowired
    public DefaultButtonAppender(@Qualifier("scenariosFromClasspath") Properties messagesFromClasspath) {
        this.messagesFromClasspath = messagesFromClasspath;
    }

    @Override
    public void append(SendMessage message, String... buttonIds) {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        Arrays.stream(buttonIds).forEach(buttonId -> {
            InlineKeyboardButton keyboardButton = new InlineKeyboardButton();
            keyboardButton.setText(messagesFromClasspath.getProperty(buttonId));
            keyboardButton.setCallbackData(buttonId);
            keyboard.add(List.of(keyboardButton));
        });

        markup.setKeyboard(keyboard);
        message.setReplyMarkup(markup);
    }
}
