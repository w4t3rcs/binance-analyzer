package com.w4t3rcs.cryptoanalyzer.redis.dao;

import com.w4t3rcs.cryptoanalyzer.binance.entity.ExchangeSymbol;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface ExchangeSymbolRepository extends ListCrudRepository<ExchangeSymbol, String>, ListPagingAndSortingRepository<ExchangeSymbol, String> {
}
