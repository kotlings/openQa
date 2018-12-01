package com.yubao.request;

import io.swagger.annotations.ApiModelProperty;

public class QueryQuestionsByUser {
    @ApiModelProperty(value = "用户id")
    private final String uid;
    @ApiModelProperty(value = "页码")
    private final int index;
    @ApiModelProperty(value = "数量")
    private final int size;

    public String getUid() {
        return uid;
    }

    public int getIndex() {
        return index;
    }

    public int getSize() {
        return size;
    }

    public QueryQuestionsByUser() {
        size = 0;
        index = 0;
        uid = null;
    }


}
