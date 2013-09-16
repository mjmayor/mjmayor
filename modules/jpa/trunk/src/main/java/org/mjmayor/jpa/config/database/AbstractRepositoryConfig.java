package org.mjmayor.jpa.config.database;

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
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableTransactionManagement
public abstract class AbstractRepositoryConfig extends WebMvcConfigurerAdapter implements RepositoryConfig {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	private DataSource dataSource;

	private JpaVendorAdapter jpaVendorAdapter;

	private Map<String, Database> databases;

	protected AbstractRepositoryConfig() {
		this.jpaVendorAdapter = jpaVendorAdapter();
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
		}
	}
}
