package com.vienna.dao;

import com.vienna.model.TokenEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenMapper {


    TokenEntity getToken(String userId);

    int insertToken(String userId, String token);

    int updateToken(String userId, String token);

    int deleteToken(String userId);

}
