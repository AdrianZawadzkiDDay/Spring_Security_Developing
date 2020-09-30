package com.example.spring_security_basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

    @GetMapping("/forAll")
    public String forAll() {
        return "all";
    }

    @GetMapping("/forUser")
    public String forUser() {
        return "user";
    }

    @GetMapping("/forAdmin")
    public String forAdmin() {
        return "admin";
    }

}
