package com.yubao.response;

import com.yubao.util.ResultConstCode;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2016-11-30.
 */
public class Response<T> {
    @ApiModelProperty(value = "状态码,200标识正常/500为异常，其他可以自己定义")
    public int code;
    @ApiModelProperty(value = "消息，当code为200时可以忽略消息，当code为500等异常时，可查看该消息查找原因")
    public String message;
    public T data;



    public Response(){
        message ="操作成功";
        code = ResultConstCode.NORMAL;
    }
}
