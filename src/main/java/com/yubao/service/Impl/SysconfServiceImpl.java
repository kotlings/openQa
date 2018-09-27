package com.yubao.service.Impl;

import com.yubao.dao.SysconfDao;
import com.yubao.service.SysconfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2016-11-28.
 */
@Service
@Qualifier("sysconfigservice")
public class SysconfServiceImpl implements SysconfigService {

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
