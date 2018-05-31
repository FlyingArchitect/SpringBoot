package com.springboot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 1、编写拦截器
 * 2、WeConfig注册 
 * @author WANGJS-PC
 *
 */
@Component//声明为bean，WeConfig中会引用
public class InterceptorTest1 implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//进入controller之前执行
		System.out.println("========preHandle1=========");
		System.out.println(((HandlerMethod) handler).getBean().getClass().getName());
		System.out.println(((HandlerMethod) handler).getMethod().getName());

		request.setAttribute("startTime1", System.currentTimeMillis());

		return true;

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//controller逻辑执行完成，还没有return
		System.out.println("========postHandle1=========");
		Long start = (Long) request.getAttribute("startTime1");
		System.out.println("耗时:" + (System.currentTimeMillis() - start));
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//controller return后执行,即页面已经显示，此方法一般处理异常
		System.out.println("========afterCompletion1=========");
		Long start = (Long) request.getAttribute("startTime1");
		System.out.println("耗时:" + (System.currentTimeMillis() - start));
		System.out.println(ex);
		System.out.println("拦截器结束");

	}

}
