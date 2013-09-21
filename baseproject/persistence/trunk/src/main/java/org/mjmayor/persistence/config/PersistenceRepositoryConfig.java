package org.mjmayor.persistence.config;

import javax.sql.DataSource;

import org.mjmayor.jpa.config.aop.JPAConfig;
import org.mjmayor.jpa.config.database.AbstractRepositoryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({ BeanRepositoryConfig.class, JPAConfig.class })
@ComponentScan("org.mjmayor.persistence")
@PropertySource("classpath:src/main/resources/config/database.properties")
@EnableTransactionManagement
public class PersistenceRepositoryConfig extends AbstractRepositoryConfig {

	@Value("${jdbc.driverClassName}")	private String driverClassName;
	@Value("${jdbc.dialect}")			private String dialect;
	@Value("${jdbc.databaseurl}")		private String databaseUrl;
	@Value("${jdbc.username}")			private String username;
	@Value("${jdbc.password}")			private String password;

	@Value("${hibernate.dialect}")		private String hibernateDialect;
	@Value("${hibernate.show_sql}")		private String hibernateShowSql;
	@Value("${hibernate.hbm2ddl.auto}")	private String hibernateHbm2ddlAuto;

	
	public PersistenceRepositoryConfig() {
		super();
	}

	@Override
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(databaseUrl);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}

	@Override
	public JpaVendorAdapter jpaVendorAdapter() {
		// HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		// jpaVendorAdapter.setDatabase(getDatabase(dialect));
		// jpaVendorAdapter.setShowSql(Boolean.parseBoolean(hibernateShowSql));
		// return jpaVendorAdapter;
		return null;
	}
}
