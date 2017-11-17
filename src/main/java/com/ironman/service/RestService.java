package com.ironman.service;

import com.ironman.defaultBean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 10:29 2017/10/23 0023
 * @Modified by:
 **/
@Service
@PropertySource("classpath:app.properties")
public class RestService {
	@Autowired
	Environment environment;

	public User findUser(String username, String psw){
		User user = new User();
		user.setUsername(username);
		user.setPsw(psw);
		user.setAge(Integer.parseInt(environment.getProperty("user.age")));
		user.setAddr(environment.getProperty("user.addr"));
		return user;
	}
}
