package com.yubao.request;

public class AddAnswerRequest {
    private  String jid;
    private  String content;

    public void setJid(String jid) {
        this.jid = jid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getJid() {
        return jid;
    }

    public String getContent() {
        return content;
    }
}
