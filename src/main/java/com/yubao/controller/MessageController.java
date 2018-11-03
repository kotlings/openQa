package com.yubao.controller;

import com.yubao.model.Message;
import com.yubao.response.Response;
import com.yubao.service.MessageService;
import com.yubao.util.ResultConstCode;
import com.yubao.response.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Response<PageObject<Message>> get(String key, int index, int size) throws IOException {
        Response<PageObject<Message>> response = new Response();
        try {
            response.data = messageService.get(key, index, size);

        } catch (Exception e) {
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }
        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public Response<Boolean> del(String id) throws IOException {
        Response<Boolean> response = new Response();
        try {
            messageService.del(id);

        } catch (Exception e) {
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }
        return response;

    }

    @ResponseBody
    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    public Response<Boolean> clear() throws IOException {
        Response<Boolean> response = new Response();
        try {
            messageService.delall();

        } catch (Exception e) {
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }
        return response;

    }
}
