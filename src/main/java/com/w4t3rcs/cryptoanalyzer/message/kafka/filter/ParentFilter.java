package com.w4t3rcs.cryptoanalyzer.message.kafka.filter;

import com.w4t3rcs.cryptoanalyzer.entity.Chart;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.jetbrains.annotations.NotNull;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;

public class ParentFilter implements RecordFilterStrategy<String, Chart> {
    @Override
    public boolean filter(@NotNull ConsumerRecord<String, Chart> consumerRecord) {
        return consumerRecord.value().getDirectionState() != Chart.DirectionState.UP;
    }
}
