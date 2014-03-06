package org.mjmayor.jpa.config.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.mjmayor.jpa.config.database.support.Dialects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({ PersistenceBeanConfig.class })
@EnableTransactionManagement
public class PersistenceConfig {

	@Value("${repository.packagesToScan}")
	private String packagesToScan;
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.databaseurl}")
	private String databaseUrl;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;

	@Value("${hibernate.dialect}")
	private String hibernateDialect;
	@Value("${hibernate.show_sql}")
	private String hibernateShowSql;
	@Value("${hibernate.hbm2ddl.auto}")
	private String hibernateHbm2ddlAuto;

	@Value("${hibernate.cache.use_second_level_cache}")
	private String useSecondLevelCache;
	@Value("${hibernate.cache.provider_class}")
	private String cacheProviderClass;
	@Value("${hibernate.cache.use_query_cache}")
	private String useQueryCache;
	@Value("${hibernate.cache.region.factory_class}")
	private String regionFactoryClass;

	private Map<String, Database> databases;

	protected PersistenceConfig() {
		super();
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

	private HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(Boolean.parseBoolean(hibernateShowSql));
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabasePlatform(hibernateDialect);
		return hibernateJpaVendorAdapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan(getPackagesToScan(packagesToScan));
		entityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter());
		entityManagerFactoryBean.setJpaProperties(additionalProperties());
		entityManagerFactoryBean.setPersistenceUnitName("transactionManager");
		return entityManagerFactoryBean;
	}
	
	@Bean
	public EntityManager entityManager() {
		return entityManagerFactory().getObject().createEntityManager();
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(databaseUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	final Properties additionalProperties() {
		Properties additionalProperties = new Properties();
		additionalProperties.setProperty("hibernate.hbm2dll.auto", hibernateHbm2ddlAuto);
		additionalProperties.setProperty("hibernate.dialect", hibernateDialect);
		additionalProperties.setProperty("hibernate.show_sql", hibernateShowSql);
		additionalProperties.setProperty("hibernate.cache.use_second_level_cache", useSecondLevelCache);
		additionalProperties.setProperty("hibernate.cache.provider_class", cacheProviderClass);
		additionalProperties.setProperty("hibernate.cache.use_query_cache", useQueryCache);
		additionalProperties.setProperty("hibernate.cache.region.factory_class", regionFactoryClass);
		return additionalProperties;
	}
}
