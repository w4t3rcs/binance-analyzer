package com.w4t3rcs.cryptoanalyzer.redis.dao;

import com.w4t3rcs.cryptoanalyzer.binance.dto.KlineUrlDto;
import com.w4t3rcs.cryptoanalyzer.binance.entity.ExchangeSymbol;
import org.springframework.data.repository.CrudRepository;

public interface KlineAnalyzerPropertiesRepository extends CrudRepository<KlineUrlDto, String> {
}
