package com.ironman.listener;

import com.ironman.defaultBean.Spittle;
import com.ironman.service.MessageReceiver;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 10:53 2017/10/24 0024
 **/
public class MessageReceivingListener implements ServletContextListener {


	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent){
		MessageReceiver messageReceiver = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext()).getBean(MessageReceiver.class);
		ListenerThread listenerThread = new ListenerThread(messageReceiver);
		listenerThread.start();
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent){

	}

	class ListenerThread extends Thread {
		private MessageReceiver messageReceiver;

		public ListenerThread(MessageReceiver messageReceiver){
			this.messageReceiver = messageReceiver;
		}

		@Override
		public void run(){
			while (true) {
				Spittle spittle = messageReceiver.retrieveSpiitleAlert();
				System.out.println("a spittle got...");
				System.out.println(spittle);
			}
		}
	}
}
