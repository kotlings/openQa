package com.yubao.controller;

import com.yubao.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016-11-29.
 */
@Controller
@RequestMapping(value="/club")
public class ClubController {
    @Autowired
    UserMapper _usermapper;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "clubindex";
    }

}
