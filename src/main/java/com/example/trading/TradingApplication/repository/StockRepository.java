package com.example.trading.TradingApplication.repository;

import com.example.trading.TradingApplication.model.StockModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockModel, Integer> {
}
