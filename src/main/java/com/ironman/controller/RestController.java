package com.ironman.controller;

import com.ironman.defaultBean.Comment;
import com.ironman.defaultBean.RestBean;
import com.ironman.defaultBean.User;
import com.ironman.service.RestService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 10:28 2017/10/23 0023
 * @Modified by:
 **/
@Controller
public class RestController {
	private static Log logger1 = LogFactory.getLog("myLogger1");
	private static Log logger2 = LogFactory.getLog("myLogger2");

	@Autowired
	RestService restService;
	@Autowired
	RestBean restBean;

	//	@Value("#{setting[add]}")
	@Value("${user.addr}")
	String addr;


	@RequestMapping("/rest/bean")
	public @ResponseBody
	User rest1(String str){
		System.out.println(restBean.getName());
		logger1.info("From logger1: " + restBean.getName());
		logger2.info("From logger2: " + restBean.getName());
		System.out.println(str);
		System.out.println(addr);
		User user = new User();
		user.setAge(12);
		user.setUsername("ironamn");
		user.setPsw("xxx");
		return user;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	User login(User user){
		System.out.println(user.getUsername());
		return user;
	}


	@RequestMapping(value = "/comment/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Comment> commentList(Comment comm){
		System.out.println("Comment list request got.");
		List<Comment> comments = new ArrayList<Comment>();
		Comment comment = new Comment();
		comment.setUsername("ironman");
		comment.setContent("good...");
		comments.add(comment);
		comments.add(comment);
		comments.add(comment);
		if(comm != null){
			System.out.println(comm.getUsername());
			System.out.println(comm.getContent());
			comments.add(comm);
		}
		return comments;
	}

	@RequestMapping(value = "/comment/add", method = RequestMethod.POST)
	public String addComment(Comment comment){
		System.out.println(comment.getUsername());
//		modelMap.addAttribute("comm", comment);
		return "redirect:/comment/list?username=" + comment.getUsername() + "&content=" + comment.getContent();
	}

	public void setAddr(String addr){
		this.addr = addr;
	}
}
