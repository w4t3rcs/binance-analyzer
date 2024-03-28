package com.w4t3rcs.cryptoanalyzer.message;

public interface MessageProducer<T> {
    void send(T message);
}
