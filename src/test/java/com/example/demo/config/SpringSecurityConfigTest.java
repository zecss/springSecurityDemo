package com.example.demo.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class SpringSecurityConfigTest {
    @Autowired
    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Test
    void passwordEncoder() {
        String mm="1234";
        String encode = passwordEncoder.encode(mm);
        System.out.println(encode);

    }
}
