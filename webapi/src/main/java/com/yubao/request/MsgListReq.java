package com.yubao.request;

import io.swagger.annotations.ApiModelProperty;

public class MsgListReq {
    @ApiModelProperty(value = "搜索关键字")
    private final String key;
    private final int index;
    private final int size;

    public MsgListReq() {
        this.key = null;
        this.index = 1;
        this.size = 10;
    }

    public String getKey() {
        return key;
    }

    public int getIndex() {
        return index;
    }

    public int getSize() {
        return size;
    }
}
