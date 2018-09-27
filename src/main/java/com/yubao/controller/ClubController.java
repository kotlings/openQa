package com.yubao.controller;

import com.yubao.dao.UserMapper;
import com.yubao.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2016-11-29.
 */
@Controller
@RequestMapping(value="/club")
public class ClubController {
    @Resource
    UserMapper _usermapper;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "clubindex";
    }

}
