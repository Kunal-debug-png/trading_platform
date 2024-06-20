package com.example.trading.TradingApplication.controller;

import com.example.trading.TradingApplication.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PortfolioController {

    @Autowired
    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @PostMapping("/buy")
    public String buyStock(@RequestParam Integer userId, @RequestParam Integer stockId, @RequestParam Integer qty, Model model) {
        portfolioService.buyStock(userId, stockId, qty);
        model.addAttribute("userId", userId);
        model.addAttribute("userBalance", portfolioService.getUserBalance(userId));
        return "transaction_success";
    }

    @PostMapping("/sell")
    public String sellStock(@RequestParam Integer userId, @RequestParam Integer stockId, @RequestParam Integer qty, Model model) {
        portfolioService.sellStock(userId, stockId, qty);
        model.addAttribute("userId", userId);
        model.addAttribute("userBalance", portfolioService.getUserBalance(userId));
        return "transaction_success";
    }
}
