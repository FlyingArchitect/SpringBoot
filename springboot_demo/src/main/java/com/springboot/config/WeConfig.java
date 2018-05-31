package com.springboot.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.springboot.filter.FilterTest1;
import com.springboot.interceptor.InterceptorTest1;
import com.springboot.listener.ListenerTest1;
import com.springboot.servlet.ServletTest;

@Configuration
public class WeConfig extends WebMvcConfigurerAdapter {
	/* 配合fastjson使用，但是没有此段代码也可返回json,可以使fastjson注解生效，不知还有没有其它作用 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

		HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;

		return new HttpMessageConverters(converter);
	}

	/* 将servlet注册成bean */
	// @Bean
	public ServletRegistrationBean servletRegistrationBean() {
		// 第二个参数为url路径
		return new ServletRegistrationBean(new ServletTest(), "/servletTest1");
	}

	/* 过滤器 */
	// @Bean
	public FilterRegistrationBean filterTest1() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		FilterTest1 filterTest1 = new FilterTest1();
		registrationBean.setFilter(filterTest1);
		List<String> urls = new ArrayList<>();
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);
		return registrationBean;
	}

	/* 监听器 */
	// @Bean
	public ServletListenerRegistrationBean<ListenerTest1> servletListenerRegistrationBean() {
		return new ServletListenerRegistrationBean<ListenerTest1>(new ListenerTest1());
	}

	@Autowired
	private InterceptorTest1 interceptorTest1;

	// 注册拦截器，先继承WebMvcConfigurerAdapter，再重写addInterceptors
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptorTest1).addPathPatterns("/**");
	}

	// 前端服务器启动端口为 8088 与后端服务器 8080 不同源，因此出现跨域的问题。
	// 现在开始解决跨域问题(即cors支持)，可以两种维度控制客户端请求。
	// 粗粒度控制（细粒度控制见controller）：
	// 方式一
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/fastjson/**").allowedOrigins("http://localhost:8088");// 允许
																							// 8088
																							// 端口访问
			}
		};
	}
	// 方式二（cors）
	// 继承WebMvcConfigurerAdapter，重写此方法
	// @Override
	// public void addCorsMappings(CorsRegistry registry) {
	// registry.addMapping("/fastjson/**")
	// .allowedOrigins("http://localhost:8088");// 允许 8088 端口访问
	// }

	

}
