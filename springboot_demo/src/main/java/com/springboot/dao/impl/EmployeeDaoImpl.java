package com.springboot.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springboot.bean.Employee;
import com.springboot.dao.EmployeeDao;
//已测试
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Employee employee) {
		String sql = "insert into user(id,username,password,birthday) values(?,?,?,?)";
		return this.jdbcTemplate.update(sql, employee.getId(), employee.getUsername(), employee.getPassword(),
				employee.getBirthday());
	}

	@Override
	public int deleteById(Integer id) {
		String sql = "delete from user where id = ?";
		return this.jdbcTemplate.update(sql, id);
	}

	@Override
	public int update(Employee employee) {
		String sql = "update user set password = ? where id = ?";
		return this.jdbcTemplate.update(sql, employee.getPassword(), employee.getId());
	}

//	sping中的RowMapper可以将数据中的每一行数据封装成用户定义的类。
//	我们在数据库查询中，如果返回的类型是用户自定义的类型(其实我们在数据库查
//	询中大部分返回的都是自定义的类)则需要包装，如果是Java自定义的类型，如：String则不需要。
//	如果sping与hibernate 相结合了,基本上是用不到,大多数都是在spring单独使用时用到，
//	常见的情况就是与JdbcTemplate一起使用。
//	可以通过建立内部类实现RowMapper接口,RowMapper中有一个mapRow方法,所以实现RowMapper
//	接口一定要实现mapRow方法,而对自定义类的包装就在mapRow方法中实现。
	@Override
	public Employee getById(Integer id) {
		String sql = "select * from user where id = ?";
		return this.jdbcTemplate.queryForObject(sql, new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setUsername(rs.getString("username"));
				employee.setPassword(rs.getString("password"));
				employee.setBirthday(rs.getDate("birthday"));
				return employee;
			}
		}, id);

	}

}
