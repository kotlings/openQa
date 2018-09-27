package com.yubao.controller;

import com.google.gson.Gson;
import com.util.Response;
import com.yubao.service.LoginService;
import com.yubao.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016-12-20.
 */
@Controller
@RequestMapping(value="/message")
public class MessageController {

    @Autowired
    MessageService messageService;


    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public void get(String key, int index, int size,
                       HttpServletResponse out) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        Response response = new Response();
        try {
            response.Status = true;
            response.Result = messageService.get(key, index, size);

        } catch (Exception e) {
            response.Message = e.getMessage();
        }
        out.getWriter().print(new Gson().toJson(response));
    }

    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public void del(String id, HttpServletResponse out) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        Response response = new Response();
        try {
        	messageService.del(id);
            response.Status = true;
        } catch (Exception e) {
            response.Message = e.getMessage();
        }
        out.getWriter().print(new Gson().toJson(response));
    }

    @ResponseBody
    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    public void clear(HttpServletResponse out) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        Response response = new Response();
        try {
        	messageService.delall();
            response.Status = true;
        } catch (Exception e) {
            response.Message = e.getMessage();
        }
        out.getWriter().print(new Gson().toJson(response));
    }
}
