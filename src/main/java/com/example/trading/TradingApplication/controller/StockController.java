package com.example.trading.TradingApplication.controller;

import com.example.trading.TradingApplication.model.StockModel;
import com.example.trading.TradingApplication.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StockController {

    @Autowired
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stocks")
    public String getAllStocks(Model model) {
        model.addAttribute("stocks", stockService.getAllStocks());
        return "stocks_page";
    }

    @PostMapping("/addStock")
    public String addStock(@ModelAttribute StockModel stockModel, @RequestParam String username) {
        if ("kunal".equals(username)) {
            stockService.addStock(stockModel.getSname(), stockModel.getSprice());
            return "stock_added_success";
        } else {
            return "error_page";
        }
    }
}
