package org.mjmayor.persistence.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.mjmayor.jpa.config.database.Dialects;
import org.mjmayor.jpa.config.database.RepositoryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Import({ BeanRepositoryConfig.class })
@EnableTransactionManagement
public class PersistenceRepositoryConfig extends WebMvcConfigurerAdapter implements RepositoryConfig {

	@Value("${jdbc.driverClassName}")	private String driverClassName;
	@Value("${jdbc.dialect}")			private String dialect;
	@Value("${jdbc.databaseurl}")		private String databaseUrl;
	@Value("${jdbc.username}")			private String username;
	@Value("${jdbc.password}")			private String password;

	@Value("${hibernate.dialect}")		private String hibernateDialect;
	@Value("${hibernate.show_sql}")		private String hibernateShowSql;
	@Value("${hibernate.hbm2ddl.auto}")	private String hibernateHbm2ddlAuto;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	private DataSource dataSource;

	private JpaVendorAdapter jpaVendorAdapter;

	private Map<String, Database> databases;

	protected PersistenceRepositoryConfig() {
		this.databases = buildDatabases();
	}

	private Map<String, Database> buildDatabases() {
		Map<String, Database> databases = new HashMap<String, Database>();
		databases.put(Dialects.MYSQL, Database.MYSQL);
		return databases;
	}

	/**
	 * {@inheritDoc}
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		initDataSource();
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(dataSource);
		localContainerEntityManagerFactoryBean.setPackagesToScan("org.mjmayor.baseproject");
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		localContainerEntityManagerFactoryBean.afterPropertiesSet();
		return localContainerEntityManagerFactoryBean.getNativeEntityManagerFactory();
	}

	/**
	 * {@inheritDoc}
	 */
	public Database getDatabase(String dialect) {
		return databases.get(dialect);
	}

	/**
	 * {@inheritDoc}
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		initDataSource();
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}

	private void initDataSource() {
		if (dataSource == null) {
			dataSource = dataSource();
			jpaVendorAdapter = jpaVendorAdapter();
		}
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
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(getDatabase(dialect));
		jpaVendorAdapter.setShowSql(Boolean.parseBoolean(hibernateShowSql));
		return jpaVendorAdapter;
	}
}
