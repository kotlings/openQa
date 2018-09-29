package com.yubao.service;

import com.yubao.dao.SysconfDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2016-11-28.
 */
@Service
public class SysconfService {

    @Autowired
    private SysconfDao _dao;

    public String getVersion() {
        return _dao.getVersion();
    }

    public int getDownload() {
        return _dao.getDownload();
    }

    public void addDownload() {
        _dao.addDownload();
    }
}
