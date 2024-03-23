package com.w4t3rcs.cryptoanalyzer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor
public class MarketChart implements Serializable {
    private String exchangeCode;
    private DirectionState directionState;

    public enum DirectionState {
        UP,
        DOWN
    }
}
