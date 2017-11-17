package com.ironman.service;

import com.ironman.DAO.UserDAO;
import com.ironman.defaultBean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 18:33 2017/10/14 0014
 * @Modified by:
 **/
@Service
public class Servicex {

	@Autowired
	UserDAO userDAO;

	public void printSth(String s){
		System.out.println(s);
	}

	public void addUser(User user){
		userDAO.addUser(user);
	}
	public List<User> getUsers(){
		return userDAO.selectUsers(getBeforeTime(66),getBeforeTime(56));
	}

	Date getBeforeTime(int minite){
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.MINUTE,calendar.get(Calendar.MINUTE)-minite);
		return calendar.getTime();
	}
}
