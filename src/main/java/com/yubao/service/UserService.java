package com.yubao.service;

import com.util.temp.PageObject;
import com.util.temp.UserViewModel;
import com.yubao.model.User;
import com.yubao.model.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2016-11-28.
 */
public interface UserService {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String id);

    int insert(User record) throws Exception;
    User check(String account,String pwd) throws Exception;

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    PageObject<UserViewModel> Get(String key, int index, int size);
}
