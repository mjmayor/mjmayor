package org.mjmayor.jpa.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public abstract class AbstractRepositoryConfig implements RepositoryConfig {

	private static final String DIALECT_MYSQL = "org.hibernate.dialect.MySQLDialect";

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	private DataSource dataSource;

	private JpaVendorAdapter jpaVendorAdapter;

	private Map<String, Database> databases;

	protected AbstractRepositoryConfig() {
		this.dataSource = dataSource();
		this.jpaVendorAdapter = jpaVendorAdapter();
		this.databases = buildDatabases();
	}

	private Map<String, Database> buildDatabases() {
		Map<String, Database> databases = new HashMap<String, Database>();
		databases.put(DIALECT_MYSQL, Database.MYSQL);
		return databases;
	}

	/**
	 * {@inheritDoc}
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory() {
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
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}
}
