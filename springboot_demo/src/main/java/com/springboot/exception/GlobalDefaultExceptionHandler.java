package com.springboot.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 全局异常，类似spring处理
 * @author WANGJS-PC
 *
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	/**
	 * 处理 Exception 类型的异常
	 * 方法名为任意名，入参一般使用 Exception 异常类，方法返回值可自定义。
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Map<String, Object> defaultExceptionHandler(Exception e) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 500);
		map.put("msg", e.getMessage());
		return map;
	}

}
