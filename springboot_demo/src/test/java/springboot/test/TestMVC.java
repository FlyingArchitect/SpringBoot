package springboot.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.SpringBootApplication;
import com.springboot.bean.Member;
import com.springboot.bean.User;
import com.springboot.controller.HomeController;
import com.springboot.controller.MemberController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootApplication.class)
@WebAppConfiguration
public class TestMVC {
	private static final Logger log = LoggerFactory.getLogger(TestMVC.class);

	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new MemberController()).build();
	}

	@Test
	public void test1() throws Exception {
		// 必须有"/"
		mvc.perform(MockMvcRequestBuilders.get("/hello1").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
		// .andExpect(content().string(equals("Hello World")));

	}

	// @WebAppConfigura巨on: 开启Web应用的配置， 用千模拟ServletContext。
	// MockMvc对象：用于模拟调用Controller的接口发起请求，
	// 在@Test定义的hello测试用例中，
	// perform函数执行 一次请求调用，
	// accept用于执行接收的数据类型，
	// andExpect用于判断接口返回的期望值。

	@Test
	public void test2() throws Exception {

		log.debug("测试get请求无参数......");

		// mock进行模拟
		mvc.perform(MockMvcRequestBuilders.get("/user/getUser").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
	}

	@Test
	public void test3() throws Exception {
		log.debug("测试get请求带参数......");

		String username = "debug-steadyjack-大圣";
		// mock进行模拟
		mvc.perform(MockMvcRequestBuilders.get("/user/getUserByName").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.param("username", username)).andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print()).andReturn();
	}

	@Test
	public void test4() throws Exception {
		log.debug("测试post请求带参数......");

		User user = new User();
		user.setId(2);
		user.setUsername("username");
		user.setPassword("password");
		log.debug("post 参数： {}", user);

		ObjectMapper objectMapper = new ObjectMapper();
		String requestJson = objectMapper.writeValueAsString(user);

		// mock进行模拟
		mvc.perform(MockMvcRequestBuilders.post("/user/saveUser").accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();

	}
	// perform：执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理；
	// get:声明发送一个get请求的方法。MockHttpServletRequestBuilder get(String urlTemplate,
	// Object...
	// urlVariables)：根据uri模板和uri变量值得到一个GET请求方式的。另外提供了其他的请求的方法，如：post、put、delete等。
	// param：添加request的参数，如上面发送请求的时候带上了了pcode =
	// root的参数。假如使用需要发送json数据格式的时将不能使用这种方式，可见后面被@ResponseBody注解参数的解决方法
	// andExpect：添加ResultMatcher验证规则，验证控制器执行完成后结果是否正确（对返回的数据进行的判断）；
	// andDo：添加ResultHandler结果处理器，比如调试时打印结果到控制台（对返回的数据进行的判断）；
	// andReturn：最后返回相应的MvcResult；然后进行自定义验证/进行下一步的异步处理（对返回的数据进行的判断）

	@Test
	public void test5() throws Exception {
		Member member = new Member();
//		member.setMid("27062931@qq.com");
//		member.setAge(11);
//		member.setSalary(12345566.00);
//		member.setBirthday(new Date());
		
		ObjectMapper objectMapper = new ObjectMapper();
		String requestJson = objectMapper.writeValueAsString(member);

		mvc.perform(MockMvcRequestBuilders.get("/addd").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				
				.param("member", requestJson)).andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print()).andReturn();

	}

}
