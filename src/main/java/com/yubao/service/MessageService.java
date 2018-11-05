package com.yubao.service;

import com.yubao.response.PageObject;
import com.yubao.dao.MessageMapper;
import com.yubao.model.*;

import com.yubao.response.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2016-12-20.
 */
@Service
public class MessageService {

    @Autowired
    MessageMapper _mapper;

    @Autowired
    LoginService _loginService;

    /**
     * 通知问题被别人回复
     * @param user
     * @param question
     */
    public void notify(User user, Question question) {
        if(user.getId().equals(question.getUserid())) {  //自己回复自己的问题
            return;
        }
        Message msg = new Message();
        msg.setId(UUID.randomUUID().toString());
        msg.setTo(question.getUserid());
        msg.setContent(user.getName() +"回复了" + question.getTitle());
        msg.setTime(new Date());
        msg.setType("系统消息");
        msg.setFrom("system");
        msg.setFromname("系统");
        msg.setTitle("通知");
        msg.setHref("/questions/detail?id=" + question.getId());


        _mapper.insertSelective(msg);
    }

    public PageObject<Message> get(String key, int index, int size) throws Exception {
        UserViewModel user = _loginService.get();
        if(user == null)
            throw new Exception("亲！等个录先~~");

        if(index == 0) index = 1;
        if(size ==0) size = 10;

        MessageExample exp = new MessageExample();

        exp.setOrderByClause("time desc");
        if(key != null && !key.equals(""))
        {
            MessageExample.Criteria criteria = exp.createCriteria();
            criteria.andContentEqualTo(key);
        }

        PageObject<Message> obj = new PageObject<Message>();
        obj.size = size;
        obj.index = index;
        obj.setTotal(_mapper.countByExample(exp));

        int startindex = (index-1)*size;
        exp.setOffset(startindex);
        exp.setLimit(size);
        obj.objects = _mapper.selectByExample(exp);

        return obj;
    }

    public void del(String id) {
        _mapper.deleteByPrimaryKey(id);
    }

    public void delall() throws Exception {
        MessageExample exp = new MessageExample();
        UserViewModel user = _loginService.get();
        if(user == null)
            throw new Exception("亲！等个录先~~");

        _mapper.deleteByUser(user.getId());
    }
}
