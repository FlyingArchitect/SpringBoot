package springboot.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import com.springboot.SpringBootApplication;
import com.springboot.controller.HomeController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootApplication.class)
@WebAppConfiguration
public class TestMVC {

	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
	}

	@Test
	public void test1() throws Exception {
		                                  //必须有"/"
		mvc.perform(MockMvcRequestBuilders.get("/hello1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
				//.andExpect(content().string(equals("Hello World")));

	}

	// @WebAppConfigura巨on: 开启Web应用的配置， 用千模拟ServletContext。
	// MockMvc对象：用于模拟调用Controller的接口发起请求，
	// 在@Test定义的hello测试用例中，
	// perform函数执行 一次请求调用，
	// accept用于执行接收的数据类型，
	// andExpect用于判断接口返回的期望值。

}
