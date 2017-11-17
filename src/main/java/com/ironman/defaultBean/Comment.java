package com.ironman.defaultBean;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 17:53 2017/10/27 0027
 **/
public class Comment {
	private String username;
	private String content;

	public Comment(){
	}

	public String getUsername(){
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getContent(){
		return content;
	}

	public void setContent(String content){
		this.content = content;
	}
}
