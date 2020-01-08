package com.vienna.controller;

import com.vienna.model.Message;
import com.vienna.request.MsgListReq;
import com.vienna.response.Response;
import com.vienna.service.MessageService;
import com.vienna.util.ResultConstCode;
import com.vienna.response.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Response<PageObject<Message>> get(@RequestBody MsgListReq msgListReq) throws IOException {
        Response<PageObject<Message>> response = new Response();
        try {
            response.data = messageService.get(msgListReq);

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
