package com.yubao.controller;

import com.yubao.model.User;
import com.yubao.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @Resource
    LoginService loginService;

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void upload(HttpServletRequest request,
                    HttpServletResponse out) throws IOException {
        out.setContentType("text/html; charset=utf-8");
        User user = loginService.get();
        if(user ==  null)
        {
            response.Status = false;
            response.Message ="亲！登个录先~~";
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


            response.Status = true;
            response.Message = "操作成功";

            String url ="http://" +request.getServerName();
            if(request.getServerPort() != 80)
            {
                url += ":" +request.getServerPort();
            }
            response.Result = url + "/upload/" +filename;
        }

        out.getWriter().print(gson.toJson(response));
    }

    private String format(String oldFilename){
        String[] str = oldFilename.split("\\.");

        return new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date()) + "."+ str[1];
    }
}
