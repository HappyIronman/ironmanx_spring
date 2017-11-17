package com.ironman.service;

import com.ironman.defaultBean.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Service;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 10:44 2017/10/24 0024
 **/
@Service
public class MessageReceiver {

	@Autowired
	JmsOperations jmsOperations;

	public Spittle retrieveSpiitleAlert(){
		System.out.println("start listening...");
		return (Spittle)jmsOperations.receiveAndConvert();
	}
}
