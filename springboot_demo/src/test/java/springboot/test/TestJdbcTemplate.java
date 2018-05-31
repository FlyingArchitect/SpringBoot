package springboot.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.springboot.SpringBootApplication;
import com.springboot.bean.Employee;
import com.springboot.dao.EmployeeDao;

@RunWith(SpringJUnit4ClassRunner.class) //// SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes = SpringBootApplication.class)
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class TestJdbcTemplate {
	@Autowired
	private EmployeeDao employeeDao;

	@Test
	public void testInsert() {
		Employee Employee = new Employee();
		Employee.setId(1);
		Employee.setUsername("张三");
		Employee.setPassword("zhangsan");
		Employee.setBirthday(new Date());
		int result = this.employeeDao.insert(Employee);
		System.out.println(result);
	}

	@Test
	public void testGetById() {
		Employee Employee = this.employeeDao.getById(1);
		System.out.println(Employee.getUsername());
	}

	@Test
	public void testUpdate() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setPassword("zhangsan123");
		this.employeeDao.update(employee);
	}

	@Test
	public void testDeleteById() {
		int result = this.employeeDao.deleteById(1);
		System.out.println("result:"+result);
	}

}
