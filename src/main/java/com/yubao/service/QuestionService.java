package com.yubao.service;

import com.yubao.request.AddAnswerRequest;
import com.yubao.request.QueryQuestionsByUser;
import com.yubao.request.QuestionListReq;
import com.yubao.response.PageObject;
import com.yubao.response.QuestionViewModel;
import com.yubao.dao.AnswerMapper;
import com.yubao.dao.QuestionMapper;
import com.yubao.dao.UserMapper;
import com.yubao.model.*;

import com.yubao.response.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2016-12-01.
 */
@Service
public class QuestionService {

	@Autowired
    QuestionMapper _mapper;

	@Autowired
    LoginService loginService;

	@Autowired
    AnswerMapper _answerMapper;
	@Autowired
    UserMapper _userMapper;

	@Autowired
    MessageService _msgService;

        public PageObject<QuestionViewModel> queryList(QuestionListReq req) {
            int index = req.getIndex();
            int size = req.getSize();
            String type = req.getType();
            String key = req.getKey();
        if(index == 0) index = 1;
        if(size ==0) size = 10;
        if(type == null) type="";

        QuestionExample exp = new QuestionExample();
        exp.setOrderByClause("stick desc,time desc");

        QuestionExample.Criteria criteria = exp.createCriteria();

        if(key != null && !key.equals(""))
        {
            criteria.andTitleLike(key);
        }

        if (type.equals("resolved")) {  //已解决
            criteria.andAcceptIsNotNull();
        } else if (type.equals("unresolved")) {  //未解决
            criteria.andAcceptIsNull();
        } else if (type.equals("wonderful")) {    //精帖
            criteria.andStatusGreaterThan(0);
        }

        PageObject<QuestionViewModel> obj = new PageObject<QuestionViewModel>();
        obj.size = size;
        obj.index = index;
        obj.setTotal(_mapper.countByExample(exp));

        int startindex = (index-1)*size;
        exp.setOffset(startindex);
        exp.setLimit(size);


        obj.objects =_mapper.getQuestionVMs(exp);

        return obj;
    }

    public String add(Question question) throws Exception {
       UserViewModel user = checkLogin();
        String id = UUID.randomUUID().toString();
        question.setUserid(user.getId());
        question.setTime(new Date());
        question.setId(id);
        _mapper.insertSelective(question);
        return id;
    }

    public String edit(Question question) throws Exception {

        _mapper.update(question);
        return "";
    }

    public void del(String id) throws Exception {
       UserViewModel user = checkLogin();
        if(user.getAuth() != 1)
        {
            throw new Exception("哇偶！快联系站长删除");
        }

        _mapper.deleteByPrimaryKey(id);
    }

    public void set(String id, String field, int rank) throws Exception {
       UserViewModel user = checkLogin();
        if(user.getAuth() != 1 && user.getAuth() != 2)
        {
            throw new Exception("哇偶！这是站长那帮人干的事");
        }

        QuestionExample exp = new QuestionExample();
        QuestionExample.Criteria criteria = exp.createCriteria();
        criteria.andIdEqualTo(id);

        Question question = _mapper.selectByPrimaryKey(id);

        if(field.equals("stick"))  //置顶
        {
            question.setStick(rank);
        }
        else if(field.equals("status")) //精贴
        {
            question.setStatus(rank);
        }
        _mapper.updateByExampleSelective(question, exp);

    }

    public void delAnswer(String id) throws Exception {
       UserViewModel user = checkLogin();
        if(user.getAuth() != 1)
        {
            throw new Exception("哇偶！快联系站长删除");
        }

        _answerMapper.deleteByPrimaryKey(id);
    }

    public void accept(String id) throws Exception {
       UserViewModel loginuser = checkLogin();
        Answer answer = _answerMapper.selectByPrimaryKey(id);

        if(loginuser.getAuth() != 1 &&loginuser.getAuth()!= 2 && answer.getUserid() == loginuser.getId() )
        {
            throw new Exception("哇偶！你无权干涉这个问题");
        }

        Question question = _mapper.selectByPrimaryKey(answer.getAnswerto());
        question.setAccept(answer.getId());
        _mapper.updateByPrimaryKey(question);

        User user = _userMapper.selectByPrimaryKey(loginuser.getId());
        user.setExperience(loginuser.getExperience() + question.getExperience());
        _userMapper.updateByPrimaryKey(user);
    }

    public PageObject<QuestionViewModel> getbyuser(QueryQuestionsByUser request) {
            int index = request.getIndex(), size = request.getSize();
        if(index == 0) index = 1;
        if(size ==0) size = 10;

        QuestionExample exp = new QuestionExample();
        exp.setOrderByClause("time desc");

        QuestionExample.Criteria criteria = exp.createCriteria();
        criteria.andUseridEqualTo(request.getUid());

        PageObject<QuestionViewModel> obj = new PageObject<QuestionViewModel>();
        obj.size = size;
        obj.index = index;
        obj.setTotal(_mapper.countByExample(exp));

        int startindex = (index-1)*size;
        exp.setOffset(startindex);
        exp.setLimit(size);


        obj.objects =_mapper.getQuestionVMs(exp);

        return obj;
    }

    public PageObject<QuestionViewModel> getByUserAnswer(QueryQuestionsByUser request) {
        int index = request.getIndex(), size = request.getSize();
        if(index == 0) index = 1;
        if(size ==0) size = 10;

        PageObject<QuestionViewModel> obj = new PageObject<QuestionViewModel>();
        obj.size = size;
        obj.index = index;
        obj.setTotal(_mapper.countByUserAnswer(request.getUid()));

        int startindex = (index-1)*size;
        obj.objects =_mapper.getByUserAnswer(request.getUid(), startindex, size);

        return obj;
    }

    public PageObject<QuestionViewModel> getHot() {
            int index = 1;
            int size = 10;
        QuestionExample exp = new QuestionExample();
        exp.setOrderByClause("hits desc,time desc");

        PageObject<QuestionViewModel> obj = new PageObject<QuestionViewModel>();
        obj.size = size;
        obj.index = index;
        obj.setTotal(_mapper.countByExample(exp));

        int startindex = (index-1)*size;
        exp.setOffset(startindex);
        exp.setLimit(size);


        obj.objects =_mapper.getQuestionVMs(exp);

        return obj;
    }

    public String addAnswer(AddAnswerRequest request) throws Exception {
       UserViewModel loginUser = checkLogin();
        String id = addAnswer(request.getJid(), request.getContent(), loginUser);

        User user = _userMapper.selectByPrimaryKey(loginUser.getId());
        user.setAnswercnt(loginUser.getAnswercnt() + 1);
        _userMapper.updateByPrimaryKey(user);

        QuestionExample exp = new QuestionExample();
        QuestionExample.Criteria criteria = exp.createCriteria();
        criteria.andIdEqualTo(request.getJid());

        Question question = _mapper.selectByPrimaryKey(request.getJid());
        question.setComment(question.getComment() + 1);
        _mapper.updateByExampleSelective(question, exp);

        _msgService.notify(user, question);
        return id;

    }

    private String addAnswer(String jid, String content, UserViewModel user) {
        String id = UUID.randomUUID().toString();
        Answer answer = new Answer();
        answer.setId(id);
        answer.setUserid(user.getId());
        answer.setContent(content);
        answer.setAnswerto(jid);
        answer.setTime(new Date());
        _answerMapper.insertSelective(answer);
        return id;
    }




    public QuestionViewModel Get(String id) {
        QuestionViewModel q = _mapper.getQuestionVM(id);
        q.answers = _answerMapper.getAnswerVMs(q.getId());
        addHitCnt(id);
        return q;
    }




    private UserViewModel checkLogin() throws Exception {
        UserViewModel user = loginService.get();
        if(user == null){
            throw new Exception("请先登录");
        }
        return user;
    }

    private void addHitCnt(String id){
        QuestionExample exp = new QuestionExample();
        QuestionExample.Criteria criteria = exp.createCriteria();
        criteria.andIdEqualTo(id);

        Question question = _mapper.selectByPrimaryKey(id);
        question.setHits(question.getHits() + 1);
        _mapper.updateByExampleSelective(question, exp);
    }
}
