package com.yubao.controller;

import com.yubao.model.Question;
import com.yubao.model.User;
import com.yubao.service.LoginService;
import com.yubao.service.QuestionService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016-11-29.
 */
@Controller
@RequestMapping(value="/questions")
public class QuestionsController extends BaseController {
    @Resource
    @Qualifier("_questionservice")
    QuestionService _service;

    @Resource
    LoginService loginService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "clubindex";
    }

    /**
     * @param out
     * @param key  关键字
     * @param type 文章类型
     * @param index
     * @param size
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public void get(HttpServletResponse out, String key, String type, int index, int size) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        response.Status = true;
        response.Result = _service.Get(key, type, index, size);

        out.getWriter().print(gson.toJson(response));
    }

    /**
     * 近期热门问题
     * @param out
     * @param key
     * @param index
     * @param size
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/gethot", method = RequestMethod.GET)
    public void getHot(HttpServletResponse out, String key, int index, int size) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        response.Status = true;
        response.Result = _service.getHot(key, index, size);

        out.getWriter().print(gson.toJson(response));
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail() {
        return "questions/detail";
    }

    @ResponseBody
    @RequestMapping(value = "/getone", method = RequestMethod.GET)
    public void getone(HttpServletResponse out, String id) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        response.Status = true;
        response.Result = _service.Get(id);
        out.getWriter().print(gson.toJson(response));
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        User user = loginService.get();
        if(user == null){
            return "login";
        }
        return "questions/add";
    }



    @ResponseBody
    @RequestMapping(value="add",method = RequestMethod.POST)
    public void add(HttpServletResponse out, Question question) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        try {
            _service.add(question);
            response.Status = true;
            response.Result = "/club/index";
            response.Message = "操作成功";
        }catch (Exception e)
        {
            response.Status = false;
            response.Message = e.getMessage();
        }

        out.getWriter().print(gson.toJson(response));
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit() {
        User user = loginService.get();
        if(user == null){
            return "login";
        }
        return "questions/edit";
    }

    @ResponseBody
    @RequestMapping(value="edit",method = RequestMethod.POST)
    public void edit(HttpServletResponse out, Question question) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        try {
            _service.edit(question);
            response.Status = true;
            response.Result = "/club/index";
            response.Message = "操作成功";
        }catch (Exception e)
        {
            response.Status = false;
            response.Message = e.getMessage();
        }

        out.getWriter().print(gson.toJson(response));
    }

    /**
     * 删除问答
     */
    @ResponseBody
    @RequestMapping(value="del",method = RequestMethod.POST)
    public void del(HttpServletResponse out, String id) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        try {
            _service.del(id);
            response.Status = true;
            response.Message = "操作成功";
        }catch (Exception e)
        {
            response.Status = false;
            response.Message = e.getMessage();
        }

        out.getWriter().print(gson.toJson(response));
    }

    /**
     * 设置问题状态
     */
    @ResponseBody
    @RequestMapping(value="set",method = RequestMethod.POST)
    public void set(HttpServletResponse out, String id, String field, int rank) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        try {
            _service.set(id, field, rank);
            response.Status = true;
            response.Message = "操作成功";
        }catch (Exception e)
        {
            response.Status = false;
            response.Message = e.getMessage();
        }

        out.getWriter().print(gson.toJson(response));
    }

    @ResponseBody
    @RequestMapping(value="addAnswer",method = RequestMethod.POST)
    public void addAnswer(HttpServletResponse out, String jid, String content) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        try {
            _service.addAnswer(jid, content);
            response.Status = true;
            response.Result ="";
            response.Message = "操作成功";
        }catch (Exception e)
        {
            response.Status = false;
            response.Message = e.getMessage();
        }

        out.getWriter().print(gson.toJson(response));
    }

    /**
     * 删除回答
     */
    @ResponseBody
    @RequestMapping(value="delAnswer",method = RequestMethod.POST)
    public void delAnswer(HttpServletResponse out, String id) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        try {
            _service.delAnswer(id);
            response.Status = true;
            response.Message = "操作成功";
        }catch (Exception e)
        {
            response.Status = false;
            response.Message = e.getMessage();
        }

        out.getWriter().print(gson.toJson(response));
    }

    /**
     * 采纳
     */
    @ResponseBody
    @RequestMapping(value="accept",method = RequestMethod.POST)
    public void accept(HttpServletResponse out, String id) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        try {
            _service.accept(id);
            response.Status = true;
            response.Message = "操作成功";
        }catch (Exception e)
        {
            response.Status = false;
            response.Message = e.getMessage();
        }

        out.getWriter().print(gson.toJson(response));
    }


    @ResponseBody
    @RequestMapping(value = "/getbyuser", method = RequestMethod.GET)
    public void getbyuser(HttpServletResponse out, String uid, int index, int size) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        response.Status = true;
        response.Result = _service.getbyuser(uid, index, size);

        out.getWriter().print(gson.toJson(response));
    }


    @ResponseBody
    @RequestMapping(value = "/getbyuseranswer", method = RequestMethod.GET)
    public void getByUserAnswer(HttpServletResponse out, String uid, int index, int size) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        response.Status = true;
        response.Result = _service.getByUserAnswer(uid, index, size);

        out.getWriter().print(gson.toJson(response));
    }

}
