package com.example.trading.TradingApplication.controller;


import com.example.trading.TradingApplication.model.UsersModel;
import com.example.trading.TradingApplication.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsersController {
    @Autowired
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest",new UsersModel());
        return "register_page";
    }
    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("LoginRequest", new UsersModel());
        return "login_page";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute UsersModel usersModel)
    {
        System.out.println("Register request"+usersModel);
        UsersModel registeredUser=usersService.registerUser(usersModel.getLogin(), usersModel.getPassword(), usersModel.getEmail());
        if(registeredUser==null){
            return "error_page";
        }
        else {
            return "login";
        }
    }
    @PostMapping("/login")
    public String login(@ModelAttribute UsersModel usersModel,Model model)
    {
        System.out.println("Login request"+usersModel);
        UsersModel authenticatedUser=usersService.authenticate(usersModel.getLogin(), usersModel.getPassword());
        if(authenticatedUser!=null)
        {
            model.addAttribute("userLogin",authenticatedUser.getLogin());
            return "personal_page";
        }
        else{
            return "redirect:/error_page";

        }
    }
}
