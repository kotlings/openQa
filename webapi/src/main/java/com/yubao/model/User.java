package com.yubao.model;

import java.util.Date;

public class User {
    private String id;

    private String account;

    private String name;

    private String pwd;

    /**
    * VIP等级
    */
    private int rmb;

    private Date createtime;

    private Date logintime;

    private String wxopenid;

    private String qqopenid;

    private int questioncnt;

    private int answercnt;

    private String pic;

    /**
    * 用户权限
    */
    private int auth;

    /**
    * 经验值
    */
    private int experience;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getRmb() {
        return rmb;
    }

    public void setRmb(int rmb) {
        this.rmb = rmb;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public String getWxopenid() {
        return wxopenid;
    }

    public void setWxopenid(String wxopenid) {
        this.wxopenid = wxopenid;
    }

    public String getQqopenid() {
        return qqopenid;
    }

    public void setQqopenid(String qqopenid) {
        this.qqopenid = qqopenid;
    }

    public int getQuestioncnt() {
        return questioncnt;
    }

    public void setQuestioncnt(int questioncnt) {
        this.questioncnt = questioncnt;
    }

    public int getAnswercnt() {
        return answercnt;
    }

    public void setAnswercnt(int answercnt) {
        this.answercnt = answercnt;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getAuth() {
        return auth;
    }

    public void setAuth(int auth) {
        this.auth = auth;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

//    public UserViewModel ToViewModel(){
//        UserViewModel vm = new UserViewModel();
//        BeanMapping mapping = BeanMapping.create(User.class, UserViewModel.class);
//        mapping.mapping(this, vm);
//        return vm;
//    }
}