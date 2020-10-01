package com.example.spring_security_basic.repositories;

import com.example.spring_security_basic.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findAllByUsername(String username);
}
