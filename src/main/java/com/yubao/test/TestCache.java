//package com.yubao.test;
//
//import com.yubao.Appllication;
//import com.yubao.model.User;
//import com.yubao.service.CacheService;
//import com.yubao.util.UuidUtil;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.boot.test.WebIntegrationTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Appllication.class)
//@WebIntegrationTest
//public class TestCache {
//
//    @Autowired
//    CacheService cacheService;
//
//    @Test
//    public void testQueryBeds(){
//        try{
//
//            User user = new User();
//            user.setAccount("test");
//
//            String key = UuidUtil.getUUID();
//            cacheService.create(key, user);
//
//            User result = cacheService.get(key);
//
//
//
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//
//}
