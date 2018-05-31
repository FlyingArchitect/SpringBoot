package com.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 此监听器也需在WeConfig中配置bean
 * 不知道是否有注解方式
 * @author WANGJS-PC
 *
 */
public class ListenerTest1 implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		 System.out.println("监听器1初始化...");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
