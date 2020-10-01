package com.example.spring_security_basic.controller;

import com.example.spring_security_basic.entities.AppUser;
import com.example.spring_security_basic.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private AppUserRepository appUserRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public MainController(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        appUserRepository.save(user);

        // po zarejestrowaniu przekierowywuje do formatki logowania
        return new ModelAndView("redirect:/login");
    }

}
