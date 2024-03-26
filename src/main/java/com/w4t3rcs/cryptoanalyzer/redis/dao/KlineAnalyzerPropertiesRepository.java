package com.w4t3rcs.cryptoanalyzer.redis.dao;

import com.w4t3rcs.cryptoanalyzer.market.KlineAnalyzerProperties;
import org.springframework.data.repository.CrudRepository;

public interface KlineAnalyzerPropertiesRepository extends CrudRepository<KlineAnalyzerProperties, String> {
}
