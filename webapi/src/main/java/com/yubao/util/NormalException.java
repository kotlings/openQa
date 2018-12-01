package com.yubao.util;

public class NormalException extends Exception {
    /**
     *自定义错误编码
     */
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public NormalException(int code, String Message){
        super(Message);
        this.setCode(code);
    }

    public NormalException(String Message){
        super(Message);
        this.setCode(500);
    }
}
