package com.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.bean.Department;
import com.springboot.dao.DepartmentMapper;
import com.springboot.service.TransactionalTest;

@Service
public class TransactionalTestImpl implements TransactionalTest {

	@Autowired
	private DepartmentMapper departmentMapper;
    //事务测试，直接在方法或类上添加注解
	@Transactional
	@Override
	public void test1() {
		Department department = new Department();
		department.setId(5);
		department.setName("楚乔5");
		department.setDescr("赵4");
		departmentMapper.insert(department);
		int i= 1/0;
		System.out.println("抛出异常");

	}

}
