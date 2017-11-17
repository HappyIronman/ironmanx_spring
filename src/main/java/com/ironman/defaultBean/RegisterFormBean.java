package com.ironman.defaultBean;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 10:47 2017/10/20 0020
 * @Modified by:
 **/
public class RegisterFormBean {
	@NotEmpty(message = "hhh")
	@Size(min=3,message = "{name.size}")
	private String name;
	@NotEmpty(message = "aaa")
	@Size(min=5,max=16,message = "uuu")
	private String psw;

	public RegisterFormBean(){
		name="ss";
		psw="ww";
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getPsw(){
		return psw;
	}

	public void setPsw(String psw){
		this.psw = psw;
	}
}
