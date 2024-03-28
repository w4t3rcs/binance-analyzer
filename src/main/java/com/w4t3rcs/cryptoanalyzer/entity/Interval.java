package com.w4t3rcs.cryptoanalyzer.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Duration;

@Getter
@RequiredArgsConstructor
public enum Interval {
    SECOND("1s", Duration.ofSeconds(1)),
    MINUTE("1m", Duration.ofMinutes(1)),
    THREE_MINUTES("3m", Duration.ofMinutes(3)),
    FIVE_MINUTES("5m", Duration.ofMinutes(5)),
    FIFTEEN_MINUTES("15m", Duration.ofMinutes(15)),
    HOUR_HALF("30m", Duration.ofMinutes(30)),
    HOUR("1h", Duration.ofHours(1)),
    TWO_HOURS("2h", Duration.ofHours(2)),
    FOUR_HOURS("4h", Duration.ofHours(4)),
    SIX_HOURS("6h", Duration.ofHours(6)),
    EIGHT_HOURS("8h", Duration.ofHours(8)),
    DAY_HALF("12h", Duration.ofHours(12)),
    DAY("1d", Duration.ofDays(1)),
    THREE_DAYS("3d", Duration.ofDays(3)),
    WEEK("1w", Duration.ofDays(7)),
    MONTH("1M", Duration.ofDays(30)),;

    private final String code;
    private final Duration duration;
}
