package com.example.trading.TradingApplication.service;

import com.example.trading.TradingApplication.model.UsersModel;
import com.example.trading.TradingApplication.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;
    public void usersService(UsersRepository usersRepository){
        this.usersRepository=usersRepository;

    }

    public UsersModel registerUser(String login, String password,String email){
        if(login == null || password==null) {
            return null;
        }
        else{
            UsersModel usersModel=new UsersModel();
            usersModel.setLogin(login);
            usersModel.setPassword(password);
            usersModel.setEmail(email);
            return usersRepository.save(usersModel);
        }
    }
    public UsersModel authenticate(String login,String password){
        return usersRepository.findByLoginAndPassword(login,password).orElse(null);
    }
}
