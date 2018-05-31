package com.springboot.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.User;

@RestController
public class FastJsonController {
	
	@RequestMapping("fastjson")
	public User test1(String username){
		User user = new User();
		user.setId(1);
		user.setUsername("username");
		user.setBirthday(new Date());
		return user;
	}

}
