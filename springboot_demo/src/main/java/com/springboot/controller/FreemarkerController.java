package com.springboot.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*页面*/
@Controller
@RequestMapping
public class FreemarkerController {
	// Freemarker 案例演示
	@RequestMapping("hello")
	public String hello(Map<String, Object> map) {
		// map是session?看起来似的
		map.put("msg", "Hello Freemarker");
		return "hello";
	}
	// Thymeleaf 案例演示，无法使用
	 @RequestMapping("thymeleaf")
	 public String thymeleaf(Map<String, Object> map){
	 map.put("msg", "Hello Thymeleaf");
	 return "thymeleaf";
	 }

}
