package com.ems;

import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages= {"com.ems"})
@EnableWebMvc
@PropertySource(value= {"classpath:/application.properties"},ignoreResourceNotFound=true)
@EnableTransactionManagement
public class SpringWebConfig {
	@Value("${database.drivername}")
	private String driverClassName;
	
	@Value("${database.username}")
	private String username;
	
	@Value("${database.password}")
	private String password;
	
	@Value("${database.url}")
	private String url;
	
	//This is were the Hibernate SQL connectivity is created as already in the Resources file, application.properties.
	@Value("${hibernate.show_sql}")
	private String showSQL;
	
	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Value("${hibernate.hbm2ddl.auto}")
	private String ddlAuto;
	
	@Value("${entirty.packagestoscan}")
	private String packagesToScanEntities;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean localSessionFactory = new LocalSessionFactoryBean();
		localSessionFactory.setPackagesToScan(packagesToScanEntities);
		localSessionFactory.setDataSource(getDataSource()); //The data source is created below.
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.show_sql",showSQL);
		hibernateProperties.setProperty("org.hibernate.dialect.MySQL5Dialect", dialect);
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", ddlAuto);
		
		localSessionFactory.setHibernateProperties(hibernateProperties);
		return localSessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		
		//Return an instance (possibly shared or independent) of the object managed by this factory.
		hibernateTransactionManager.setSessionFactory(getSessionFactory().getObject());
		return hibernateTransactionManager;
	}
	
	//Hibernate configuration ends here.
	
	//Below code is used to configure the JDBC template.
	@Bean
	public DataSource getDataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driverClassName);
		return dataSource;			
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
}
