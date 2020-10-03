package com.example.spring_security_basic.controller;

import com.example.spring_security_basic.entities.AppUser;
import com.example.spring_security_basic.repositories.AppUserRepository;
import com.example.spring_security_basic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/singup")
    public ModelAndView singup() {
        return new ModelAndView("registration", "user", new AppUser());
    }

    @RequestMapping("/register")
    public ModelAndView register(AppUser user) {
        userService.addNewUser(user);
        // po zarejestrowaniu przekierowywuje do formatki logowania
        return new ModelAndView("redirect:/login");
    }

}
