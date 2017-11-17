package com.ironman.defaultBean;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 10:30 2017/10/23 0023
 * @Modified by:
 **/
public class User implements Serializable{

	String username;
	String psw;
	String addr;
	Date createDate;
	int age;

	public User(){
	}

	public String getUsername(){
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getPsw(){
		return psw;
	}

	public void setPsw(String psw){
		this.psw = psw;
	}

	public String getAddr(){
		return addr;
	}

	public void setAddr(String addr){
		this.addr = addr;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age = age;
	}

	public Date getCreateDate(){
		return createDate;
	}

	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}

	@Override
	public String toString(){
		return "User{" +
				"username='" + username + '\'' +
				", psw='" + psw + '\'' +
				", addr='" + addr + '\'' +
				", createDate=" + createDate +
				", age=" + age +
				'}';
	}
}
