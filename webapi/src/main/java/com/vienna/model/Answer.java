package com.vienna.model;

import java.util.Date;

public class Answer {
    private String id;

    private String content;

    private int supportcnt;

    private int opposecnt;

    private String answerto;

    private Date time;

    private String userid;

    /**
    * 是否采纳
    */
    private int accept;

    private int praise;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSupportcnt() {
        return supportcnt;
    }

    public void setSupportcnt(int supportcnt) {
        this.supportcnt = supportcnt;
    }

    public int getOpposecnt() {
        return opposecnt;
    }

    public void setOpposecnt(int opposecnt) {
        this.opposecnt = opposecnt;
    }

    public String getAnswerto() {
        return answerto;
    }

    public void setAnswerto(String answerto) {
        this.answerto = answerto;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getAccept() {
        return accept;
    }

    public void setAccept(int accept) {
        this.accept = accept;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

//    public AnswerViewModel ToViewModel(){
//        AnswerViewModel vm = new AnswerViewModel();
//        BeanMapping mapping = BeanMapping.create(Answer.class, AnswerViewModel.class);
//        mapping.mapping(this, vm);
//        return vm;
//    }
}
