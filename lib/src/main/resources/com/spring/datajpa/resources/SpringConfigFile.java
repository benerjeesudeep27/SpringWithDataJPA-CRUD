package com.spring.datajpa.resources;

import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.spring.datajpa.repository")
@ComponentScan("com.spring.datajpa")
public class SpringConfigFile {
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_datajpa_db");
		dataSource.setUsername("root");
		dataSource.setPassword("Shiva@12345");
		return dataSource;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		bean.setPackagesToScan("com.spring.datajpa.entity");
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		Properties prop = new Properties();
		prop.put(Environment.HBM2DDL_AUTO, "update");
		prop.put(Environment.SHOW_SQL, "true");
		prop.put(Environment.FORMAT_SQL, "true");
		bean.setJpaProperties(prop);
		return bean;
	}
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFactory().getObject());
		return manager;
	}
}
