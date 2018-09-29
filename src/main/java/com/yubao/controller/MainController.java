package com.yubao.controller;

import com.yubao.service.SysconfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public ModelAndView GetVersion() {
        ModelAndView modelAndView = new ModelAndView("version");
        modelAndView.addObject("version", sysconfigservice.getVersion());
        modelAndView.addObject("download", sysconfigservice.getDownload());
        return modelAndView;
    }

    @RequestMapping(value="/addDownload", method = RequestMethod.POST)
    public void AddDownload(PrintWriter out) throws IOException {
    	sysconfigservice.addDownload();
        out.print("ok");
    }
}