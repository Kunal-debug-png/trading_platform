package com.example.trading.TradingApplication.service;

import com.example.trading.TradingApplication.model.PortfolioModel;
import com.example.trading.TradingApplication.model.StockModel;
import com.example.trading.TradingApplication.model.UsersModel;
import com.example.trading.TradingApplication.repository.PortfolioRepository;
import com.example.trading.TradingApplication.repository.StockRepository;
import com.example.trading.TradingApplication.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private UsersRepository usersRepository;

    public void buyStock(Integer userId, Integer stockId, Integer qty) {
        UsersModel user = usersRepository.findById(userId).orElse(null);
        StockModel stock = stockRepository.findById(stockId).orElse(null);

        if (user != null && stock != null) {
            double totalCost = stock.getSprice() * qty;
            if (user.getBalance() >= totalCost) {
                user.setBalance(user.getBalance() - totalCost);
                PortfolioModel portfolio = new PortfolioModel();
                portfolio.setUser(user);
                portfolio.setStock(stock);
                portfolio.setQty(qty);
                portfolio.setPrice(stock.getSprice());
                portfolioRepository.save(portfolio);
                usersRepository.save(user);
            }
        }
    }

    public void sellStock(Integer userId, Integer stockId, Integer qty) {
        UsersModel user = usersRepository.findById(userId).orElse(null);
        StockModel stock = stockRepository.findById(stockId).orElse(null);

        if (user != null && stock != null) {
            List<PortfolioModel> portfolios = portfolioRepository.findByUserId(userId);
            for (PortfolioModel portfolio : portfolios) {
                if (portfolio.getStock().getSid().equals(stockId) && portfolio.getQty() >= qty) {
                    portfolio.setQty(portfolio.getQty() - qty);
                    double totalCredit = stock.getSprice() * qty;
                    user.setBalance(user.getBalance() + totalCredit);
                    if (portfolio.getQty() == 0) {
                        portfolioRepository.delete(portfolio);
                    } else {
                        portfolioRepository.save(portfolio);
                    }
                    usersRepository.save(user);
                    break;
                }
            }
        }
    }

    public double getUserBalance(Integer userId) {
        return usersRepository.findById(userId).orElse(new UsersModel()).getBalance();
    }
}
