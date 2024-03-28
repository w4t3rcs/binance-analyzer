package com.w4t3rcs.cryptoanalyzer.message;

public interface MessageConsumer<T> {
    void listen(T message);
}
