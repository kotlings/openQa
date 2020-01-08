package com.vienna.service;

import com.vienna.request.LoginRequest;
import com.vienna.util.MD5;
import com.vienna.response.PageObject;
import com.vienna.response.UserViewModel;
import com.vienna.dao.UserMapper;
import com.vienna.model.User;
import com.vienna.model.UserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Administrator on 2016-11-30.
 */
@Service
public class UserService {
	@Autowired
	@Qualifier("userMapper")
    UserMapper userMapper;
	
    public int countByExample(UserExample example) {
        return userMapper.countByExample(example);
    }

    public int deleteByExample(UserExample example) {
        return userMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(String id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public int insert(User record) throws Exception {
        UserExample exp = new UserExample();
        UserExample.Criteria criteria = exp.createCriteria();
        criteria.andAccountEqualTo(record.getAccount());
        if(countByExample(exp) > 0)
            throw new Exception("账号已存在");

        record.setId(UUID.randomUUID().toString());
        record.setPic(new Random().nextInt(9) +".jpg");
        record.setCreatetime(new Date());
        return userMapper.insert(record);
    }

    public  User login(LoginRequest request) throws Exception {
        UserExample exp = new UserExample();
        UserExample.Criteria criteria = exp.createCriteria();
        criteria.andAccountEqualTo(request.getAccount());

        List<User> user = selectByExample(exp);
        if(user.isEmpty())
            throw new Exception("用户不存在");

        String md5pwd = MD5.Encode(request.getPwd());
        if(!user.get(0).getPwd().equals(md5pwd))
        {
            throw new Exception("密码错误");
        }
        return user.get(0);
    }

    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    public List<User> selectByExample(UserExample example) {
        return userMapper.selectByExample(example);
    }

    public User selectByPrimaryKey(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example) {
        return userMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(@Param("record") User record, @Param("example") UserExample example) {
        return userMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    public PageObject<UserViewModel> GetNew() {
        int index = 1;
        int size = 12;

        UserExample exp = new UserExample();

        exp.setOrderByClause("createtime desc");


        PageObject<UserViewModel> obj = new PageObject<UserViewModel>();
        obj.size = size;
        obj.index = index;
        obj.setTotal(userMapper.countByExample(exp));

        int startindex = (index-1)*size;
        exp.setOffset(startindex);
        exp.setLimit(size);
        List<User> users= userMapper.selectByExample(exp);
        if(users != null && users.size() > 0){
            obj.objects = UserViewModel.From(users);
        }

        return obj;
    }
}
