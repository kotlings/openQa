package com.vienna.dao;

import com.vienna.model.TokenEntity;
import com.vienna.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenMapper {


    TokenEntity getToken(String userId);

    User get(String userId);

    int insertToken(String userId, String token);

    int updateToken(String userId, String token);

    int deleteToken(String userId);

}
