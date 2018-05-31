package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@RestController返回的都是json
@RestController
public class HomeController {
	@RequestMapping("hello1")
	public String test1(){
		return "Hello SpringBoot";
	}
	@RequestMapping("hello2")
	public String test2(){
		return "hello2";
	}

}
