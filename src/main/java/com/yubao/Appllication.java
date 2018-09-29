package com.yubao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "com.yubao")
@EnableSwagger2
public class Appllication {
	public static void main(String[] args) {
		SpringApplication.run(Appllication.class, args);
	}
	
//	@Bean
//	public ServletListenerRegistrationBean<BedListerner> servletListenerRegistrationBean(){
//		ServletListenerRegistrationBean<BedListerner> servletListenerRegistrationBean = new ServletListenerRegistrationBean<BedListerner>();
//		servletListenerRegistrationBean.setListener(new BedListerner());
//		return servletListenerRegistrationBean;
//	}
}
