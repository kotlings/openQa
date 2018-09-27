package com.yubao.service.Impl;

import com.util.Const;
import com.yubao.model.User;
import com.yubao.service.LoginService;
import com.yubao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016-12-04.
 */
@Service
@Qualifier("loginfService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    HttpServletRequest request;

    @Autowired
    @Qualifier("userService")
    UserService userService;

    public User get() {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {

                if (cookie.getName().equals(Const.COOKIE_LOGIN_USER)) {
                    String id = cookie.getValue();
                    if(id != null && !id.equals("")){
                        User user = userService.selectByPrimaryKey(id);
                        return user;
                    }
                }
            }
        }
        return null;
    }
}
