package com.ironman.defaultBean;

import java.io.Serializable;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 10:29 2017/10/24 0024
 **/
public class Spittle implements Serializable {
	private String name;
	private int age;

	public Spittle(){
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age = age;
	}

	@Override
	public String toString(){
		return "Spittle{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
