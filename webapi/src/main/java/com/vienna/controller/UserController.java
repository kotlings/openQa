package com.vienna.controller;

import com.vienna.request.AddUserReq;
import com.vienna.request.LoginRequest;
import com.vienna.service.CacheService;
import com.vienna.util.Const;
import com.vienna.util.MD5;
import com.vienna.response.Response;
import com.vienna.util.ResultConstCode;
import com.vienna.response.PageObject;
import com.vienna.response.UserViewModel;
import com.vienna.model.User;
import com.vienna.service.LoginService;
import com.vienna.service.UserService;
import com.vienna.util.UuidUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016-11-29.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginfService;

    @Autowired
    CacheService cacheService;


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletResponse out) {
        Cookie cookie = new Cookie(Const.COOKIE_LOGIN_USER,"");
        cookie.setMaxAge(-1);
        cookie.setPath("/");
        out.addCookie(cookie);
        return "clubindex";
    }


    @ResponseBody
    @RequestMapping(value = "/getLoginUser", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "获取登陆的用户")
    public Response<UserViewModel> getLoginUser() throws IOException {
        Response<UserViewModel> response = new Response();
        try {
            UserViewModel user = loginfService.get();
            if(user == null){
                response.code = ResultConstCode.ERROR_500;
                response.data = null;
            }else{
                response.data =user;
            }

        } catch (Exception e) {
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/getbyid", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户的基本信息")
    public Response<UserViewModel> getbyid(String uid) throws IOException {
        Response<UserViewModel> response = new Response();
        try {
            User user = userService.selectByPrimaryKey(uid);
            if(user == null){
                response.code = ResultConstCode.ERROR_500;
                response.data = null;
            }else{
                response.data = UserViewModel.From(user);
            }

        } catch (Exception e) {
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }
        return response;
    }

    @ResponseBody
    @ApiOperation(value = "添加用户")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Response<Boolean> addUser(@RequestBody AddUserReq addUserReq) throws IOException {
        Response<Boolean> response = new Response();
        try {
            User user = new User();
            user.setName(addUserReq.getName());
            user.setAccount(addUserReq.getAccount());
            user.setPwd(MD5.Encode(addUserReq.getPwd()));

            userService.insert(user);

        } catch (Exception e) {
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }
        return response;
    }

    @ResponseBody
    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response<String> login(@RequestBody LoginRequest loginRequest) throws IOException {
        Response<String> response = new Response();
        try {
            User u = userService.login(loginRequest);
            UserViewModel userVM = UserViewModel.From(u);
            String token = UuidUtil.getUUID();
            cacheService.create(token, userVM);
            response.data = token;
        } catch (Exception e) {
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }
        return response;

    }

    @ResponseBody
    @ApiOperation(value = "获取最新注册的用户")
    @RequestMapping(value = "/getnew", method = RequestMethod.GET)
    public Response<PageObject<UserViewModel>> getnew() throws IOException {
        Response<PageObject<UserViewModel>> response = new Response<>();
        try{
            response.data = userService.GetNew();

        }catch(Exception e){
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }

        return response;

    }
}
