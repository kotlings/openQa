package com.yubao.controller;

import com.yubao.service.SysconfService;
import com.yubao.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 主控制器
 * Created by Administrator on 2016-11-17.
 */
@Controller
@RequestMapping(value="/main")
public class MainController {

    @Autowired
    SysconfService sysconfigservice;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "version";
    }


	/**
	 * 
	 * @return
	 */
    @RequestMapping(value = "/getversion", method = RequestMethod.GET)
    @ResponseBody
    public Response GetVersion() {
        Version v = new Version();
        v.setVersion(sysconfigservice.getVersion());
        v.setDownload(sysconfigservice.getDownload());
        Response response = new Response();
        response.Status = true;
        response.Result = v;
        return response;
    }

    @RequestMapping(value="/addDownload", method = RequestMethod.POST)
    public void AddDownload(PrintWriter out) throws IOException {
    	sysconfigservice.addDownload();
        out.print("ok");
    }

    class Version{
        private String version;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public int getDownload() {
            return download;
        }

        public void setDownload(int download) {
            this.download = download;
        }

        private int download;

    }
}