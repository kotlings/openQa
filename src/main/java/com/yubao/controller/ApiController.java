package com.yubao.controller;

import com.alibaba.fastjson.JSON;
import com.yubao.model.User;
import com.yubao.response.UserViewModel;
import com.yubao.service.LoginService;
import com.yubao.util.ResultConstCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
    @Autowired
    LoginService loginService;

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public com.yubao.response.Response upload(HttpServletRequest request,
                                              HttpServletResponse out) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        UserViewModel user = loginService.get();
        if(user ==  null)
        {
            response.code = ResultConstCode.ERROR_500;
            response.message ="亲！登个录先~~";
        }
        else{
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            CommonsMultipartFile orginalFile = (CommonsMultipartFile) multipartRequest
                    .getFile("file");// 表单中对应的文件名；

            String filename = format(orginalFile.getOriginalFilename());  //服务器上的文件名

            String path = request.getRealPath("/upload") +"/"+ filename;  //linux不能用\\
            File newFile=new File(path);
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            orginalFile.transferTo(newFile);


            String url ="http://" +request.getServerName();
            if(request.getServerPort() != 80)
            {
                url += ":" +request.getServerPort();
            }
            response.data = url + "/upload/" +filename;
        }

        return response;
    }

    private String format(String oldFilename){
        String[] str = oldFilename.split("\\.");

        return new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date()) + "."+ str[1];
    }
}
