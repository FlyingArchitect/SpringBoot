package com.springboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
/**
 * 拦截器preHandle方法执行后，执行此方法
 * @author WANGJS-PC
 *
 */
@Aspect
@Component
public class AopTest1 {

	@Around("execution(* com.springboot.controller.FastJsonController..*(..))")
	public Object method(ProceedingJoinPoint pjp) throws Throwable {

		//System.out.println("=====Aspect处理=======");
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			//args为controllr里方法的数组
			System.out.println("参数为:" + arg);
		}

		long start = System.currentTimeMillis();
        //处理controller里具体业务逻辑
		Object object = pjp.proceed();

		//System.out.println("Aspect 耗时:" + (System.currentTimeMillis() - start));

		return object;
	}
	//结束后，进入拦截器的postHandle

}
