package springboot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.springboot.SpringBootApplication;
import com.springboot.bean.Department;
import com.springboot.dao.DepartmentMapper;
import com.springboot.service.TransactionalTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootApplication.class)
@WebAppConfiguration
public class TestMybatis {
	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private TransactionalTest transactionalTest;

	@Test
	public void testInsert() {
		Department department = new Department();
		department.setId(1);
		department.setName("研发部");
		department.setDescr("开发产品");
		this.departmentMapper.insert(department);
	}

	@Test
	public void testGetById() {
		Department department = this.departmentMapper.getById(1);
		System.out.println(department);
	}

	@Test
	public void testUpdate() {
		Department department = new Department();
		department.setId(1);
		department.setDescr("开发高级产品");
		this.departmentMapper.update(department);
	}

	@Test
	public void testDeleteById() {
		this.departmentMapper.deleteById(1);
	}
	//事务测试
	@Test
	public void test1(){
		transactionalTest.test1();
		System.out.println("完成");
	}

}
