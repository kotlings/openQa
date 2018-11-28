package com.yubao.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="appsettings")
public class AppSettings {
    //nginx中，上传的静态图片端口
    private int picfilesport;

    public int getPicfilesport() {
        return picfilesport;
    }

    public void setPicfilesport(int picfilesport) {
        this.picfilesport = picfilesport;
    }
}
