package com.example.trading.TradingApplication.repository;

import com.example.trading.TradingApplication.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel,Integer> {
    Optional<UsersModel> findByLoginAndPassword(String login, String password);

}
