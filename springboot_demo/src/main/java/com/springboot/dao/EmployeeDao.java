package com.springboot.dao;

import com.springboot.bean.Employee;
/*测试JdbcTemplate接口*/
public interface EmployeeDao {
	
	public int insert(Employee employee);

	public int deleteById(Integer id);

	public int update(Employee employee);

	public Employee getById(Integer id);

}
