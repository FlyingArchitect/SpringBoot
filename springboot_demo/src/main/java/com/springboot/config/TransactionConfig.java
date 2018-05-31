package com.springboot.config;

import javax.persistence.EntityManagerFactory;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

//测试未通过
//@Configuration
//@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
public class TransactionConfig // implements TransactionManagementConfigurer
{

	@Bean
	public PlatformTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	// 事务
	@Bean
	public Object testBean(PlatformTransactionManager platformTransactionManager) {
		System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
		return new Object();
	}

	// 创建事务管理器1
	@Bean(name = "txManager1")
	public PlatformTransactionManager txManager1(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	// 创建事务管理器2
	@Bean(name = "txManager2")
	public PlatformTransactionManager txManager2(EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}

	// 实现接口 TransactionManagementConfigurer 方法，其返回值代表在拥有多个事务管理器的情况下默认使用的事务
	// @Override
	// public PlatformTransactionManager annotationDrivenTransactionManager() {
	// // TODO Auto-generated method stub
	// return txManager2;
	// }

}
