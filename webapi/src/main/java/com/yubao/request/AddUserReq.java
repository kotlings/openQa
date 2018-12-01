package com.yubao.request;

import io.swagger.annotations.ApiModelProperty;

public class AddUserReq {
    @ApiModelProperty(value = "用户昵称/姓名")
    private String name;
    @ApiModelProperty(value = "用户账号")
    private String account;
    @ApiModelProperty(value = "密码")
    private String pwd;

    public void setName(String name) {
        this.name = name;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public String getPwd() {
        return pwd;
    }
}
