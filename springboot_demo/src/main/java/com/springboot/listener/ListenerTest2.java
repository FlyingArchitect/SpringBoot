package com.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 第二种。
 * 见启动类
 * @author WANGJS-PC
 *
 */
public class ListenerTest2 implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		 System.out.println("监听器2初始化...");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
