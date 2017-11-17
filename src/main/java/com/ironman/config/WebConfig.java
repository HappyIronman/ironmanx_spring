package com.ironman.config;

import com.ironman.defaultBean.RestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 15:42 2017/10/23 0023
 **/
@Configuration
public class WebConfig {
//	@Bean
//	public ViewResolver cnViewResolver(ContentNegotiationManager cnm){
//		ContentNegotiatingViewResolver resolver =new ContentNegotiatingViewResolver();
//		resolver.setContentNegotiationManager(cnm);
//		return resolver;
//	}
//
//	@Bean
//	public ViewResolver beanNameViewResolver(){
//		return new BeanNameViewResolver();
//	}


}
