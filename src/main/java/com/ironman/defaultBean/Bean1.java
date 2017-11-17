package com.ironman.defaultBean;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 17:05 2017/10/18 0018
 * @Modified by:
 **/
public class Bean1 {
	private String name;

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public void print(){
		System.out.println(this.name);
	}
}
