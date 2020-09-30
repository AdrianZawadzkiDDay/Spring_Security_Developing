package com.example.spring_security_basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestApi {

    @GetMapping("/forAll")
    public String forAll() {
        return "This is endpoint permitted for all";
    }

    @GetMapping("/forUser")
    public String forUser(Principal principal) {
        return "Hello user: " + principal.getName();
    }

    @GetMapping("/forAdmin")
    public String forAdmin(Principal principal) {
        return "Hello Admin: " + principal.getName();
    }

    @GetMapping("/bye")
    public String forLogOut() {
        return "you have been loged out";
    }

}
