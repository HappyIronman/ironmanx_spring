package com.ironman.controller;

import com.ironman.defaultBean.Bean1;
import com.ironman.defaultBean.RegisterFormBean;
import com.ironman.defaultBean.Spittle;
import com.ironman.defaultBean.User;
import com.ironman.service.AllertService;
import com.ironman.service.Servicex;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 15:53 2017/10/14 0014
 * @Modified by:
 **/
@Controller
public class TestController {

	private static Logger logger = Logger.getLogger(TestController.class);

	@Autowired
	Servicex servicex;

	@Autowired
	AllertService allertService;

	@ModelAttribute
	public void preMethod(){

	}

	@RequestMapping("/x")
	public String sss(@RequestParam(value = "name", defaultValue = "EMPTY", required = true) String var){
		servicex.printSth(var);
		return "index";
	}

	@RequestMapping("/x1")
	public String x1(@RequestParam(value = "name") String x, ModelMap modelMap){
		System.out.println(x);
		modelMap.addAttribute("var", x);
		return "index";
	}

	@RequestMapping("/x2")
	public String x2(@ModelAttribute("bean") Bean1 bean1){
		return "index";
	}

	@RequestMapping("/exception")
	public void handleException(){
		System.out.println("Exception occured.");
		logger.error("shit!");
		throw new RuntimeException("hahaha");
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String register(Model model){

		model.addAttribute("registerFormBean", new RegisterFormBean());
		return "register";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String submitRegister(@Valid RegisterFormBean registerForm, BindingResult result, ModelMap modelMap){
		logger.info("fuck!");
		if(result.hasErrors()){
			return "register";
		}
		modelMap.addAttribute("var", registerForm.getPsw());
		return "index";
	}


	@RequestMapping(value = "/sendMsg", method = RequestMethod.GET)
	public String sendMsg(){
		Spittle spittle = new Spittle();
		spittle.setName("Ironman");
		spittle.setAge(12);
		allertService.sendSpittleAlert(spittle);
		logger.info("Ironman sent!");
		return "index";
	}


	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
	@ResponseBody
	public String createUser(final String name){
		new Thread() {
			@Override
			public void run(){
				int i = 0;
				while (i < 100) {
					User user = new User();
					user.setUsername(name + Calendar.getInstance().get(Calendar.MINUTE)
							+ ":" + Calendar.getInstance().get(Calendar.SECOND));
					user.setPsw("123456");
					user.setCreateDate(new Date());
					servicex.addUser(user);
					System.out.println(i + "...");
					try {
						Thread.sleep(1000 * 55);
					} catch(InterruptedException e){
						e.printStackTrace();
					}
					i++;
				}
			}
		}.start();

		return "ok";
	}

	@RequestMapping(value = "user/get", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUser(ModelMap modelMap){
		return servicex.getUsers();
	}
}
