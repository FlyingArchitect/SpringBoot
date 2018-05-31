package com.springboot.bean;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String username;

	private String password;
	//Fastjson注解，直接将new Date()转换为相应格式的日期
    @JSONField(format="yyyy-MM-dd")
	private Date birthday;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", birthday=" + birthday + "]";
	}
	
	

}
