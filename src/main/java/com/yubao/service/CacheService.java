package com.yubao.service;

import com.google.common.collect.Lists;
import com.yubao.model.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"token"})
public class CacheService {

    @CachePut(value = "userCache",key = "#key")
    public void create(String key, User user){
    }

    @Cacheable(value = "userCache",key = "#key")
    public User get(String key){
        return null;
    }


    @CacheEvict(value = "userCache",key = "#key")
    public void delete(String key){
    }

}