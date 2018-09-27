package com.yubao.controller;

import com.util.Const;
import com.util.MD5;
import com.util.Response;
import com.util.temp.UserViewModel;
import com.yubao.model.User;
import com.yubao.service.LoginService;
import com.yubao.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016-11-29.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    @Qualifier("userService")
    UserService userService;

    @Autowired
    @Qualifier("loginfService")
    LoginService loginfService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String reg() {
        return "reg";
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String message() {
        return "user/message";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "user/index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletResponse out) {
        Cookie cookie = new Cookie(Const.COOKIE_LOGIN_USER,"");
        cookie.setMaxAge(-1);
        cookie.setPath("/");
        out.addCookie(cookie);
        return "clubindex";
    }

    /**
     * 获取登陆的用户
     * @param request
     * @param out
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public void getUser(HttpServletRequest request, HttpServletResponse out) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        Response resp = new Response();
        User user = loginfService.get();
        if(user == null){
            resp.Status = false;
            resp.Result = null;
        }else{
            resp.Status = true;
            resp.Result = UserViewModel.From(user);
        }

        out.getWriter().print(gson.toJson(resp));
    }

    @ResponseBody
    @RequestMapping(value = "/getbyid", method = RequestMethod.GET)
    public void getbyid(String uid, HttpServletResponse out) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        Response resp = new Response();
        User user = userService.selectByPrimaryKey(uid);
        if(user == null){
            resp.Status = false;
            resp.Result = null;
        }else{
            resp.Status = true;
            resp.Result = UserViewModel.From(user);
        }

        out.getWriter().print(gson.toJson(resp));
    }

    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(HttpServletResponse out,String name, String account, String pwd) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        try {

            User user = new User();
            user.setName(name);
            user.setAccount(account);
            user.setPwd(MD5.Encode(pwd));

            userService.insert(user);
            response.Status = true;
        } catch (Exception e) {
            response.Status = false;
            response.Message = e.getMessage();
        }
        out.getWriter().print(gson.toJson(response));
    }

    @ResponseBody
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public void checkUser(HttpServletResponse out, String account, String pwd) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        try {
            User u = userService.check(account, pwd);
            Cookie cookie = new Cookie(Const.COOKIE_LOGIN_USER, u.getId());
            cookie.setPath("/");
            cookie.setMaxAge(360000);
            out.addCookie(cookie);
            response.Status = true;
        } catch (Exception e) {
            response.Status = false;
            response.Message = e.getMessage();
        }
        out.getWriter().print(gson.toJson(response));
    }

    @ResponseBody
    @RequestMapping(value = "/getnew", method = RequestMethod.GET)
    public void getnew(HttpServletResponse out, String key, int index, int size) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        response.Status = true;
        response.Result = userService.Get(key, index, size);

        out.getWriter().print(gson.toJson(response));
    }
}
