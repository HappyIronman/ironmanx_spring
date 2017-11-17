package com.ironman.defaultBean;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 17:40 2017/10/18 0018
 * @Modified by:
 **/
public class TestBean1 {
	private String name;
	private int id;
	private List<String> list;
	private Set<String> set;
	private Map<String,String> map;

	public TestBean1(){
	}

	public TestBean1(String name,int id){
		this.name = name;
		this.id=id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public List<String> getList(){
		return list;
	}

	public void setList(List<String> list){
		this.list = list;
	}

	public Set<String> getSet(){
		return set;
	}

	public void setSet(Set<String> set){
		this.set = set;
	}

	public Map<String, String> getMap(){
		return map;
	}

	public void setMap(Map<String, String> map){
		this.map = map;
	}

	@Override
	public String toString(){
		return "name:"+this.name+"\n"+"id:"+this.id+"\nmap:"+this.map.toString()
				+"\nset:"+this.set.toString()+"\nlist:"+this.list.toString();
	}
}
