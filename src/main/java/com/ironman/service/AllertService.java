package com.ironman.service;

import com.ironman.defaultBean.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 10:28 2017/10/24 0024
 **/
@Service
public class AllertService {
	@Autowired
	private JmsOperations jmsOperations;

	public void sendSpittleAlert(final Spittle spittle){
		jmsOperations.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException{
				return session.createObjectMessage(spittle);
			}
		});
	}

	public void simpleSendAlert(Spittle spittle){
		jmsOperations.convertAndSend(spittle);
	}
}
