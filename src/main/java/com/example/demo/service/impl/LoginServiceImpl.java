package com.example.demo.service.impl;

import com.example.demo.domain.LoginUser;
import com.example.demo.domain.User;
import com.example.demo.service.LoginService;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.RedisCache;
import com.example.demo.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LoginServiceImpl  implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    /*登录
    * 返回token
    * 用户信息存入redis
    * */
    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
//        认证
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
//        获取用户信息
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
//        获取用户id
        String userId = loginUser.getUser().getId().toString();
//        生成jwt
        String jwt = JwtUtil.createJWT(userId);
//        用户信息存入redis
        redisCache.setCacheObject("login:"+userId,loginUser);
//        返回信息
        return new ResponseResult(200,"success",jwt);
    }
}
