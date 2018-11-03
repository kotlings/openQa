package com.yubao.controller;

import com.yubao.model.Question;
import com.yubao.request.AddAnswerRequest;
import com.yubao.request.QuestionListReq;
import com.yubao.service.LoginService;
import com.yubao.service.QuestionService;
import com.yubao.response.Response;
import com.yubao.util.ResultConstCode;
import com.yubao.response.PageObject;
import com.yubao.response.QuestionViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by Administrator on 2016-11-29.
 */
@Controller
@RequestMapping(value="/questions")
public class QuestionsController extends BaseController {
    @Resource
    @Autowired
    QuestionService _service;

    @Autowired
    LoginService loginService;

    /**
     *
     * @param questionListReq@throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    public Response<PageObject<QuestionViewModel>> queryList(@RequestBody QuestionListReq questionListReq) {

        Response<PageObject<QuestionViewModel>> response = new Response<>();
        try{
            response.data = _service.queryList(questionListReq);

        }catch(Exception e){
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }
        return response;
    }

    /**
     * 近期热门问题
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/gethot", method = RequestMethod.GET)
    public  Response<PageObject<QuestionViewModel>> getHot() throws IOException {

        Response<PageObject<QuestionViewModel>> response = new Response<>();
        try{
            response.data = _service.getHot();

        }catch(Exception e){
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }

        return response;
    }


    @ResponseBody
    @RequestMapping(value = "/getone", method = RequestMethod.GET)
    public Response<QuestionViewModel> getone( String id) throws IOException {
        Response<QuestionViewModel> response = new Response<>();
        try{
            response.data = _service.Get(id);

        }catch(Exception e){
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }

        return response;
    }



    @ResponseBody
    @RequestMapping(value="add",method = RequestMethod.POST)
    public Response<String> add(@RequestBody Question question) throws IOException {
        Response<String> response = new Response<>();
        try{
            response.data = _service.add(question);

        }catch(Exception e){
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }

        return response;
    }


    @ResponseBody
    @RequestMapping(value="edit",method = RequestMethod.POST)
    public Response<Boolean> edit(@RequestBody Question question) throws IOException {
        Response<Boolean> response = new Response<>();
        try{
            _service.edit(question);

        }catch(Exception e){
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }

        return response;
    }

    /**
     * 删除问答
     */
    @ResponseBody
    @RequestMapping(value="del",method = RequestMethod.POST)
    public Response<Boolean> del(@RequestBody String id) throws IOException {
        Response<Boolean> response = new Response<>();
        try{
            _service.del(id);

        }catch(Exception e){
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }

        return response;
    }

    /**
     * 设置问题状态
     */
    @ResponseBody
    @RequestMapping(value="set",method = RequestMethod.POST)
    public Response<Boolean> set( String id, String field, int rank) throws IOException {
        Response<Boolean> response = new Response<>();
        try {
            _service.set(id, field, rank);

        } catch (Exception e) {
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }

        return response;
    }

    @ResponseBody
    @RequestMapping(value="addAnswer",method = RequestMethod.POST)
    public Response<String> addAnswer(@RequestBody AddAnswerRequest addAnswerRequest) throws IOException {
        Response<String> response = new Response<>();
        try {
            response.data = _service.addAnswer(addAnswerRequest);

        } catch (Exception e) {
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }

        return response;

    }

    /**
     * 删除回答
     */
    @ResponseBody
    @RequestMapping(value="delAnswer",method = RequestMethod.POST)
    public Response<Boolean> delAnswer( String id) throws IOException {
        Response<Boolean> response = new Response<>();
        try {
            _service.delAnswer(id);

        } catch (Exception e) {
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }

        return response;

    }

    /**
     * 采纳
     */
    @ResponseBody
    @RequestMapping(value="accept",method = RequestMethod.POST)
    public Response<Boolean> accept( String id) throws IOException {
        Response<Boolean> response = new Response<>();
        try {
            _service.accept(id);

        } catch (Exception e) {
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }

        return response;
    }


    @ResponseBody
    @RequestMapping(value = "/getbyuser", method = RequestMethod.GET)
    public Response<PageObject<QuestionViewModel>> getbyuser( String uid, int index, int size) throws IOException {
        Response<PageObject<QuestionViewModel>> response = new Response<>();
        try {
            response.data = _service.getbyuser(uid, index, size);

        } catch (Exception e) {
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }

        return response;
    }


    @ResponseBody
    @RequestMapping(value = "/getbyuseranswer", method = RequestMethod.GET)
    public Response<PageObject<QuestionViewModel>> getByUserAnswer( String uid, int index, int size) throws IOException {
        Response<PageObject<QuestionViewModel>> response = new Response<>();
        try {
            response.data = _service.getByUserAnswer(uid, index, size);

        } catch (Exception e) {
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }

        return response;
    }

}
