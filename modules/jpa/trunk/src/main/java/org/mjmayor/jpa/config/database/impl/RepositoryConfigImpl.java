package org.mjmayor.jpa.config.database.impl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.mjmayor.jpa.config.database.RepositoryConfig;
import org.mjmayor.jpa.config.database.support.Dialects;
import org.mjmayor.jpa.config.database.support.PersistenceBeanConfig;
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
@Import({ PersistenceBeanConfig.class })
@EnableTransactionManagement
public class RepositoryConfigImpl extends WebMvcConfigurerAdapter implements RepositoryConfig {

	@Value("${repository.packagesToScan}")	private String packagesToScan;
	
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

	protected RepositoryConfigImpl() {
		this.databases = buildDatabases();
	}

	private Map<String, Database> buildDatabases() {
		Map<String, Database> databases = new HashMap<String, Database>();
		databases.put(Dialects.MYSQL, Database.MYSQL);
		return databases;
	}

	private String[] getPackagesToScan(String originalString) {
		return originalString.split(",");
	}

	public Database getDatabase(String dialect) {
		return databases.get(dialect);
	}

	private void initDataSource() {
		if (dataSource == null) {
			dataSource = dataSource();
			jpaVendorAdapter = jpaVendorAdapter();
		}
	}

	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(databaseUrl);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}

	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(getDatabase(dialect));
		jpaVendorAdapter.setShowSql(Boolean.parseBoolean(hibernateShowSql));
		return jpaVendorAdapter;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		initDataSource();
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(dataSource);
		localContainerEntityManagerFactoryBean.setPackagesToScan(getPackagesToScan(packagesToScan));
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		localContainerEntityManagerFactoryBean.afterPropertiesSet();
		return localContainerEntityManagerFactoryBean.getNativeEntityManagerFactory();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Bean
	public PlatformTransactionManager transactionManager() {
		initDataSource();
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Bean(name = "entityManager")
	public EntityManager entityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
