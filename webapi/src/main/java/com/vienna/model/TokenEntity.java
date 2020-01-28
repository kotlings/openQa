package com.vienna.model;

import java.io.Serializable;

public class TokenEntity implements Serializable {


    private String userId;

    private String token;


    public String getUser_id() {
        return userId;
    }

    public void setUser_id(String user_id) {
        this.userId = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
