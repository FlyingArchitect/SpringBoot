package com.springboot.bean;

import java.io.Serializable;
import java.util.Date;
/*jdbcTemplate实体类*/
public class Employee implements Serializable {

	private static final long serialVersionUID = -3313311623510135726L;

	private Integer id;
	private String username;
	private String password;
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
		return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", birthday=" + birthday
				+ "]";
	}
	

}
