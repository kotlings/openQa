package com.vienna.service;

import com.vienna.response.UserViewModel;
import com.vienna.util.RedisUtils;
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
    @Autowired
    TokenService tokenService;

    @Autowired
    private RedisUtils redisUtils;

    public UserViewModel get() {

        //todo 判断token的类型
        String token = request.getHeader("X-Token");
        if (token != null && !token.equals("")) {
            if (token.length() > 100) {
//                redisUtils.get(token)
                return tokenService.get(token);
            } else {
                return cacheService.get(token);
            }
        }
        return null;
    }
}
