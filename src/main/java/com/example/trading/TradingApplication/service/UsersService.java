package com.example.trading.TradingApplication.service;

import com.example.trading.TradingApplication.model.UsersModel;
import com.example.trading.TradingApplication.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public UsersModel registerUser(String login, String password, String email){
        if(login == null || password == null) {
            return null;
        }
        UsersModel usersModel = new UsersModel();
        usersModel.setLogin(login);
        usersModel.setPassword(password);
        usersModel.setEmail(email);
        usersModel.setBalance(5000.0);
        return usersRepository.save(usersModel);
    }

    public UsersModel authenticate(String login, String password){
        List<UsersModel> users = usersRepository.findAllByLoginAndPassword(login, password);
        if (users.size() == 1) {
            return users.get(0);
        } else {
            // Handle error or log warning if multiple users are found
            if (users.size() > 1) {
                System.out.println("Warning: Multiple users found with the same login and password.");
            }
            return null;
        }
    }
}
