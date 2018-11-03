package com.yubao.response;

import com.yubao.util.ResultConstCode;

/**
 * Created by Administrator on 2016-11-30.
 */
public class Response<T> {
    public int code;
    public String message;
    public T data;



    public Response(){
        message ="操作成功";
        code = ResultConstCode.NORMAL;
    }
}
