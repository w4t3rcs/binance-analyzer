package com.w4t3rcs.cryptoanalyzer.message;

public interface MessageBuilder<K, T, V> {
    K build(T text, V v);
}
