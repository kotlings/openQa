package com.yubao.request;

import io.swagger.annotations.ApiModelProperty;

public class QuestionListReq {
    private final String key;
    @ApiModelProperty(value = "resolved：已解决/unresolved：未解决/wonderful：精贴")
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
