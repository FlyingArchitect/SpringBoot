package com.springboot.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * 此处主要用来测试事务机制
 * 
 * spring Boot 使用事务非常简单，首先使用注解 @EnableTransactionManagement
 * 开启事务支持后，然后在访问数据库的Service方法上添加注解 @Transactional 便可。
 * 关于事务管理器，不管是JPA还是JDBC等都实现自接口 PlatformTransactionManager 如果你添加的是
 * spring-boot-starter-jdbc 依赖，框架会默认注入 DataSourceTransactionManager 实例。如果你添加的是
 * spring-boot-starter-data-jpa 依赖，框架会默认注入 JpaTransactionManager 实例。
 * 
 * @author WANGJS-PC
 *
 */
public interface TransactionalTest {
    //接口上直接添加此注解不管用
	@Transactional
	public void test1();

}
