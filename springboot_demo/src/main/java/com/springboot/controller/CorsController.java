package com.springboot.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.User;

/**
 * 类中的方法上添加 @CrossOrigin(origins=”xx”) 
 * 注解 在使用该注解时，需要注意 @RequestMapping 使用的请求方式类型，即 GET 或 POST。
 * 
 * @author WANGJS-PC
 *
 */
@RestController
public class CorsController {

	@RequestMapping("/cros")
	@CrossOrigin(origins = "http://localhost:8088")
	public User test() {
		User user = new User();

		user.setId(1);
		user.setUsername("jack");
		user.setPassword("jack123");
		user.setBirthday(new Date());

		return user;
	}

}
