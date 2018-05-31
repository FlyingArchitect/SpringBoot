package com.springboot.dao;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.bean.Department;

/*mybatis接口*/
/*此处必须有注解，否则无法生成bean*/
@Mapper
public interface DepartmentMapper {
	public void insert(Department department);

	public Department getById(Integer id);

	public void update(Department department);

	public void deleteById(Integer id);

}
