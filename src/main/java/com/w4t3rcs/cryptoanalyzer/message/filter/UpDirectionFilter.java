package com.w4t3rcs.cryptoanalyzer.message.filter;

import com.w4t3rcs.cryptoanalyzer.entity.MarketChart;

public class UpDirectionFilter implements IntegrationFilter<MarketChart> {
    @Override
    public boolean filter(MarketChart data) {
        return data.getDirectionState() == MarketChart.DirectionState.UP;
    }
}
