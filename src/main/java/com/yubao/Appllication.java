package com.yubao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JndiConnectionFactoryAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration(exclude = {JndiConnectionFactoryAutoConfiguration.class,DataSourceAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class,JpaRepositoriesAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class})
@SpringBootApplication
@ComponentScan(basePackages = "com.yubao")
@MapperScan("com.yubao.dao")
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
