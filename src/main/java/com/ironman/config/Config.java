package com.ironman.config;

import com.ironman.aopTest.Audience;
import com.ironman.aopTest.Performance;
import com.ironman.defaultBean.Bean1;
import com.ironman.defaultBean.RestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 17:01 2017/10/18 0018
 * @Modified by:
 **/
@Configuration
//@ComponentScan({"com.ironman.service"})
//@ImportResource(locations = {"classpath:applicationContext.xml"})
@PropertySource("classpath:app.properties")
@EnableAspectJAutoProxy
public class Config {
	@Autowired
	Environment environment;

	@Bean
	Bean1 bean1(){
		Bean1 bean1=new Bean1();
		bean1.setName(environment.getProperty("bean1.name"));
		return bean1;
	}

	@Bean
	public Performance performance(){
		return new Performance();
	}

	@Bean
	public Audience audience(){
		return new Audience();
	}

	@Bean
	RestBean restBean(){
		RestBean bean=new RestBean();
		bean.setName("ironman");
		return bean;
	}
}
