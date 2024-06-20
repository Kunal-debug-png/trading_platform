package com.example.trading.TradingApplication.repository;

import com.example.trading.TradingApplication.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {
    Optional<UsersModel> findByLoginAndPassword(String login, String password);
    Optional<UsersModel> findByLogin(String login);

    // Change return type to List to handle multiple results
    List<UsersModel> findAllByLoginAndPassword(String login, String password);
}
