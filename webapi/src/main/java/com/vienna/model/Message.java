package com.vienna.model;

import java.util.Date;

public class Message {
    private String id;

    private Date time;

    private String content;

    private String href;

    private String from;

    private String to;

    /**
    * 来源方状态
    */
    private int fromstatus;

    /**
    * 到达方状态
    */
    private int tostatus;

    /**
    * 类型
    */
    private String type;

    /**
    * 来源方名称
    */
    private String fromname;

    /**
    * 到达方名字
    */
    private String toname;

    private int read;

    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getFromstatus() {
        return fromstatus;
    }

    public void setFromstatus(int fromstatus) {
        this.fromstatus = fromstatus;
    }

    public int getTostatus() {
        return tostatus;
    }

    public void setTostatus(int tostatus) {
        this.tostatus = tostatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFromname() {
        return fromname;
    }

    public void setFromname(String fromname) {
        this.fromname = fromname;
    }

    public String getToname() {
        return toname;
    }

    public void setToname(String toname) {
        this.toname = toname;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
