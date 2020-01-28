package com.vienna.service;

import com.vienna.dao.TokenMapper;
import com.vienna.model.TokenEntity;
import com.vienna.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016-11-30.
 */
@Service
public class TokenService {

    @Autowired
//    @Qualifier("tbTokenMap")
    private TokenMapper tokenMapper;


    @Autowired
    private JwtUtils jwtUtils;


    public int insertToken(String id) {
        String token = jwtUtils.generateToken(id);
        return tokenMapper.insertToken(id, token);
    }

    public int updateToken(String id) {
        String token = jwtUtils.generateToken(id);
        return tokenMapper.updateToken(id, token);
    }

    public int deleteToken(String id) {

        return tokenMapper.deleteToken(id);
    }


    public TokenEntity getToken(String id) {

        return tokenMapper.getToken(id);
    }

}
