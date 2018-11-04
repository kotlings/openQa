package com.yubao.test;

import com.yubao.Appllication;
import com.yubao.model.User;
import com.yubao.service.CacheService;
import com.yubao.util.UuidUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Appllication.class)
public class TestCache {

    @Autowired
    CacheService cacheService;

    @Test
    public void testQueryBeds(){
        try{

            User user = new User();
            user.setAccount("test");

            String key = UuidUtil.getUUID();
            cacheService.create(key, user);

            User result = cacheService.get(key);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
