package com.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.User;

//@RestController返回的都是json
@RestController
public class HomeController {
	private static final String prex = "user";
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("hello1")
	public String test1() {
		return "Hello SpringBoot";
	}

	@RequestMapping("hello2")
	public String test2() {
		return "hello2";
	}

	/**
	 *  以下测试使用
	 *  get请求无参数
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = prex + "/getUser", method = RequestMethod.GET)
	public User getUserDto() throws Exception {
		User user = new User();
		user.setId(1);
		user.setUsername("无所谓");
		user.setPassword("123456");

		return user;
	}

	/**
	 * get请求带参数
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = prex
			+ "/getUserByName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User getUserByName(String username) throws Exception {
		log.debug("请求参数： {}", username);

		User user = new User();
		user.setUsername(username);

		return user;
	}

	/**
	 * post请求-application/json的格式 - 其他的也是一个道理
	 * 
	 * @param userDto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = prex
			+ "/saveUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User saveUserDto(@RequestBody User user) throws Exception {
		log.debug("post请求插入参数： {}", user);

		return user;
	}

}
