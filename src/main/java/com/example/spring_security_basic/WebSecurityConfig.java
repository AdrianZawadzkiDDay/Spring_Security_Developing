package com.example.spring_security_basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // WebSecurityConfigurerAdapter dodaje domyslną formatke logowania

    @Bean
    PasswordEncoder getPasswordEncodrr() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User userAdmin = new User("Jan",
                getPasswordEncodrr().encode("jan123"),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));

        User userUser = new User("Karol",
                getPasswordEncodrr().encode("karol123"),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));

        // uzytkownicy przechowywani w pamieci
        auth.inMemoryAuthentication().withUser(userAdmin);
        auth.inMemoryAuthentication().withUser(userUser);

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // dostep do endpointow
        http.authorizeRequests()
                .antMatchers("/forAdmin").hasRole("ADMIN")
                .antMatchers("/forUser").hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin().permitAll() // dopusc wszystkich do formatki logowania
                .and()
                .logout().logoutSuccessUrl("/bye");
    }
}
