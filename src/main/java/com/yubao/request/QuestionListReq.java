package com.yubao.request;

public class QuestionListReq {
    private final String key;
    private final String type;
    private final int index;
    private final int size;

    public String getKey() {
        return key;
    }

    public String getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }

    public int getSize() {
        return size;
    }

    public QuestionListReq() {
        this.type = null;
        size = 0;
        index = 0;
        key = null;
    }


}
