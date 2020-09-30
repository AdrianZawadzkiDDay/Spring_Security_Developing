package com.example.spring_security_basic;

import com.example.spring_security_basic.entities.AppUser;
import com.example.spring_security_basic.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private PasswordEncoder passwordEncoder;

    private AppUserRepository appUserRepository;

    @Autowired
    public Start(PasswordEncoder passwordEncoder, AppUserRepository appUserRepository) {
        this.passwordEncoder = passwordEncoder;
        this.appUserRepository = appUserRepository;

        AppUser appUser = new AppUser();
        appUser.setUsername("Mirek");
        appUser.setPassword(passwordEncoder.encode("mirek"));

        appUserRepository.save(appUser);
    }
}
