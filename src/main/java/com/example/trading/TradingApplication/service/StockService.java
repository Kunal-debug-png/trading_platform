package com.example.trading.TradingApplication.service;

import com.example.trading.TradingApplication.model.StockModel;
import com.example.trading.TradingApplication.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public StockModel addStock(String sname, Double sprice) {
        StockModel stockModel = new StockModel();
        stockModel.setSname(sname);
        stockModel.setSprice(sprice);
        return stockRepository.save(stockModel);
    }

    public List<StockModel> getAllStocks() {
        return stockRepository.findAll();
    }
}
