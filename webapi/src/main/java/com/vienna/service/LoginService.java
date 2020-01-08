package com.vienna.service;

import com.vienna.response.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 从缓存中读取用户信息
 */
@Service
public class LoginService {

    @Autowired
    HttpServletRequest request;

    @Autowired
    UserService userService;

    @Autowired
    CacheService cacheService;

    public UserViewModel get() {

        String token = request.getHeader("X-Token");
        if(token != null && !token.equals("")){
            return cacheService.get(token);
        }
        return null;
    }
}
