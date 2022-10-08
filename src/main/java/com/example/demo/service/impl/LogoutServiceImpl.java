package com.example.demo.service.impl;

import com.example.demo.domain.LoginUser;
import com.example.demo.service.LogoutService;
import com.example.demo.utils.RedisCache;
import com.example.demo.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LogoutServiceImpl implements LogoutService {
    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult logout() {
//        获取认证信息 删除redis中用户信息
//        1.获取认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

//        2.获取redis key
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userId = loginUser.getUser().getId();
        String redisKey = "login:"+userId;
        redisCache.deleteObject(redisKey);
        return new ResponseResult(200,"注销成功");
    }
}
