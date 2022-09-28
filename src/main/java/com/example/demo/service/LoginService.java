package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.utils.ResponseResult;

public interface LoginService {
    ResponseResult login(User user);
}
