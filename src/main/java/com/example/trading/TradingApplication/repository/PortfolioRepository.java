package com.example.trading.TradingApplication.repository;

import com.example.trading.TradingApplication.model.PortfolioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<PortfolioModel, Integer> {
    List<PortfolioModel> findByUserId(Integer userId);
}
