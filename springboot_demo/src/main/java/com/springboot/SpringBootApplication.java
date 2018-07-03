package com.springboot;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;

//此处不知为什么@SpringBootApplication不能使用
@org.springframework.boot.autoconfigure.SpringBootApplication
// @ServletComponentScan //启动注解方式的servlet
public class SpringBootApplication implements ServletContainerInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}

	// 实现ServletContainerInitializer
	// 针对自定义 Servlet、Filter 和 Listener 的配置，还有另一种方式：
	// 末生效
	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		// 配置 Servlet
//		ctx.addServlet("servletTest3", new ServletTest3()).addMapping("/servletTest3");
		// 配置过滤器
//		ctx.addFilter("filterTest3", new FilterTest3()).addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),
//				true, "/*");
		// 配置监听器
//		ctx.addListener(new ListenerTest2());
	}

}
