package com.vienna.model;

import java.util.Date;

public class Question {
    private String id;

    private String title;

    private String content;

    private int supportcnt;

    private int opposecnt;

    private String commentto;

    /**
    * 创建时间
    */
    private Date time;

    private String userid;

    /**
    * 浏览量
    */
    private int hits;

    /**
    * 置顶
    */
    private int stick;

    /**
    * 回答数
    */
    private int comment;

    /**
    * 加精
    */
    private int status;

    /**
    * 悬赏
    */
    private int experience;

    /**
    * 采纳
    */
    private String accept;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCommentto() {
        return commentto;
    }

    public void setCommentto(String commentto) {
        this.commentto = commentto;
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

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getStick() {
        return stick;
    }

    public void setStick(int stick) {
        this.stick = stick;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

//    public QuestionWithAnswers ToViewModel(){
//        QuestionWithAnswers vm = new QuestionWithAnswers();
//        BeanMapping mapping = BeanMapping.create(Question.class, QuestionWithAnswers.class);
//        mapping.mapping(this, vm);
//        return vm;
//    }
}
