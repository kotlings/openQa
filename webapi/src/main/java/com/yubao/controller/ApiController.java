package com.yubao.controller;

import com.alibaba.fastjson.JSON;
import com.yubao.configure.AppSettings;
import com.yubao.model.User;
import com.yubao.response.UserViewModel;
import com.yubao.service.LoginService;
import com.yubao.util.ResultConstCode;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016-12-18.
 */
@Controller
@RequestMapping(value="/api")
public class ApiController extends BaseController {
    public static final String UPLOAD_FOLDER = "/upload_files/";
    @Autowired
    LoginService loginService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    AppSettings appSettings;

    private final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ApiOperation(value = "文件上传", httpMethod = "POST")
    public com.yubao.response.Response upload(@RequestParam("file") MultipartFile file) throws IOException {
        UserViewModel user = loginService.get();
        logger.info(JSON.toJSONString(user));
        if(user ==  null)
        {
            response.code = ResultConstCode.ERROR_500;
            response.message ="亲！登个录先~~";
        }
        else{
            String filename = format(file.getOriginalFilename());  //服务器上的文件名
            String path = System.getProperty("user.dir") + UPLOAD_FOLDER + filename;  //linux不能用\\
            logger.info("upload path:"+ path);
            File newFile=new File(path);
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            file.transferTo(newFile);

            String url ="http://" +request.getServerName() +":" + appSettings.getPicfilesport();
            response.data = url + UPLOAD_FOLDER +filename;
        }

        return response;
    }

    private String format(String oldFilename){
        String[] str = oldFilename.split("\\.");

        return new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date()) + "."+ str[1];
    }
}
