package com.yubao.service;

import com.yubao.util.Const;
import com.yubao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016-12-04.
 */
@Service
public class LoginService {

    @Autowired
    HttpServletRequest request;

    @Autowired
    UserService userService;

    public User get() {

        String id = request.getHeader("X-Token");
        if(id != null && !id.equals("")){
            User user = userService.selectByPrimaryKey(id);
            return user;
        }
        return null;
    }
}
