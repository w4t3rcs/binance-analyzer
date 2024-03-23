package com.w4t3rcs.cryptoanalyzer.message.filter;

public interface IntegrationFilter<T> {
    boolean filter(T data);
}
