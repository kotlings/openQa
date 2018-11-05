package com.yubao.service;

import com.yubao.response.UserViewModel;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 使用ehcache缓存登录信息
 * 存储在缓存名称为“token”中，该名称必须在ehcache-setting.xml中进行配置
 */
@Service
@CacheConfig(cacheNames = {"token"})
public class CacheService {

    @CachePut(key = "#key")
    public UserViewModel create(String key, UserViewModel UserViewModel){
        return UserViewModel;
    }

    @Cacheable(key = "#key")
    public UserViewModel get(String key){
        return null;
    }


    @CacheEvict(key = "#key")
    public void delete(String key){
    }

}