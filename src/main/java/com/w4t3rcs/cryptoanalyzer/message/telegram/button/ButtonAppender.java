package com.w4t3rcs.cryptoanalyzer.message.telegram.button;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.Properties;

public interface ButtonAppender {
    void append(SendMessage message, String... buttonIds);
}
