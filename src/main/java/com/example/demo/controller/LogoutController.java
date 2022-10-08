package com.example.demo.controller;


import com.example.demo.service.LogoutService;
import com.example.demo.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {

    @Autowired
    private LogoutService logoutService;

    @GetMapping("/user/logout")
    public ResponseResult logout(){
        return logoutService.logout();
    }
}
