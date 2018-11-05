package com.yubao.test;

import com.alibaba.fastjson.JSON;
import com.yubao.Appllication;
import com.yubao.model.User;
import com.yubao.response.UserViewModel;
import com.yubao.service.CacheService;
import com.yubao.util.UuidUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Appllication.class)
public class TestCache {

    @Autowired
    CacheService cacheService;

    @Test
    public void testQueryBeds(){
        try{

            UserViewModel user = new UserViewModel();
            user.setName("test");

            String key = UuidUtil.getUUID();
            cacheService.create(key, user);

            UserViewModel result = cacheService.get(key);
            System.out.print(JSON.toJSONString(result));

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
