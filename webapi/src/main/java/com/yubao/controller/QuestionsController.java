package com.yubao.controller;

import com.yubao.model.Question;
import com.yubao.request.AddAnswerRequest;
import com.yubao.request.QueryQuestionsByUser;
import com.yubao.request.QuestionListReq;
import com.yubao.service.LoginService;
import com.yubao.service.QuestionService;
import com.yubao.response.Response;
import com.yubao.util.ResultConstCode;
import com.yubao.response.PageObject;
import com.yubao.response.QuestionViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @ApiOperation(value = "贴子列表")
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
     * 近期热门贴子
     * @throws IOException
     */
    @ResponseBody
    @ApiOperation(value = "近期热门贴子")
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
    @ApiOperation(value = "获取一个贴子的详细情况")
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
    @ApiOperation(value="发布一个贴子")
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
    @ApiOperation(value = "修改贴子")
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
     * 删除贴子
     */
    @ResponseBody
    @RequestMapping(value="del",method = RequestMethod.POST)
    @ApiOperation(value = "删除贴子")
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

    @ResponseBody
    @RequestMapping(value="set",method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "管理员设置贴子的一些属性值，比如置顶状态、精贴")
    public Response<Boolean> set( String id,
                                  @ApiParam(value = "当为stick标识【置顶】，为status标识【精贴】")
                                  String field,
                                  @ApiParam(value = "1为设置，0为取消")
                                  int rank) throws IOException {
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
    @ApiOperation(value = "回答一个贴子")
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
    @ApiOperation(value="删除一个回复")
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

    @ResponseBody
    @ApiOperation(value = "采纳一个回复为最优回复（即问题的答案）")
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
    @ApiOperation(value = "获取用户发的贴子")
    @RequestMapping(value = "/getbyuser", method = RequestMethod.GET)
    public Response<PageObject<QuestionViewModel>> getbyuser(@RequestBody QueryQuestionsByUser request) throws IOException {
        Response<PageObject<QuestionViewModel>> response = new Response<>();
        try {
            response.data = _service.getbyuser(request);

        } catch (Exception e) {
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }

        return response;
    }


    @ResponseBody
    @ApiOperation(value = "获取用户【回复过】的贴子")
    @RequestMapping(value = "/getbyuseranswer", method = RequestMethod.GET)
    public Response<PageObject<QuestionViewModel>> getByUserAnswer( @RequestBody QueryQuestionsByUser request) throws IOException {
        Response<PageObject<QuestionViewModel>> response = new Response<>();
        try {
            response.data = _service.getByUserAnswer(request);

        } catch (Exception e) {
            response.code = ResultConstCode.ERROR_500;
            response.message = e.getMessage();
        }

        return response;
    }

}
