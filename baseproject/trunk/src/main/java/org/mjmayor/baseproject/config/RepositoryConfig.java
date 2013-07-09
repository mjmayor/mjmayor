package org.mjmayor.baseproject.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class RepositoryConfig {

	@Value("${jdbc.driverClassName}")	private String driverClassName;
	@Value("${jdbc.databaseurl}")		private String databaseUrl;
	@Value("${jdbc.username}")			private String username;
	@Value("${jdbc.password}")			private String password;

	@Value("${hibernate.dialect}")		private String hibernateDialect;
	@Value("${hibernate.show_sql}")		private String hibernateShowSql;
	@Value("${hibernate.hbm2ddl.auto}")	private String hibernateHbm2ddlAuto;

	
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(databaseUrl);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}

	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", hibernateDialect);
		properties.put("hibernate.show_sql", hibernateShowSql);
		properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
		return properties;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManager() {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(dataSource());
		entityManager.setJpaDialect(new HibernateJpaDialect());
		entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//		entityManager.setPersistenceUnitName("mjmayor");
		entityManager.setJpaProperties(getHibernateProperties());
//		entityManager.setPackagesToScan(new String[] { "org.mjmayor.baseproject" });
		return entityManager;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager jpatm = new JpaTransactionManager();
//		jpatm.setEntityManagerFactory(entityManager());
		return jpatm;
	}

	// @Bean
	// public LocalSessionFactoryBean sessionFactory() {
	// LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
	// bean.setDataSource(getDataSource());
	// bean.setHibernateProperties(getHibernateProperties());
	// bean.setPackagesToScan(new String[] { "org.mjmayor.baseproject" });
	// return bean;
	// }
}
