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
import com.springboot.bean.Role;
import com.springboot.dao.EmployeeDao;
import com.springboot.dao.RoleRepository;

@RunWith(SpringJUnit4ClassRunner.class) //// SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes = SpringBootApplication.class)
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class TestJpa {
	@Autowired
	private RoleRepository roleRepository;

	@Test
	public void testInsert() {
		Role role = new Role();
		role.setName("管理员");
		role.setDescr("测试");
		Role result = this.roleRepository.save(role);
		System.out.println(result);
	}

	@Test
	public void testFindOne() {
		Role role = this.roleRepository.findOne(1);
		System.out.println(role);
	}

	@Test
	public void testUpdate() {
		Role role = new Role();
		role.setId(1);
		role.setName("管理员");
		role.setDescr("控制权限");
		Role result = this.roleRepository.save(role);
		System.out.println(result);
	}

	@Test
	public void testDelete() {
		this.roleRepository.delete(1);
	}
}
