package com.w4t3rcs.cryptoanalyzer.message.telegram.scenario;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Scenario {
    SendMessage buildScenario(Update update);
}
