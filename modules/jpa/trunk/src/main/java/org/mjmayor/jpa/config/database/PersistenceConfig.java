package org.mjmayor.jpa.config.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.mjmayor.jpa.config.database.support.Dialects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Import({ PersistenceBeanConfig.class })
@EnableTransactionManagement
public class PersistenceConfig extends WebMvcConfigurerAdapter {

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

	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(databaseUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	/**
	 * {@inheritDoc}
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
		entityManagerFactoryBean.setPackagesToScan(getPackagesToScan(packagesToScan));
		entityManagerFactoryBean.setJpaProperties(jpaProperties());
		return entityManagerFactoryBean;
	}

	private Properties jpaProperties() {
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.dialect", hibernateDialect);
		jpaProperties.setProperty("hibernate.show_sql", hibernateShowSql);
		jpaProperties.setProperty("hibernate.cache.use_second_level_cache", useSecondLevelCache);
		jpaProperties.setProperty("hibernate.cache.provider_class", cacheProviderClass);
		jpaProperties.setProperty("hibernate.cache.use_query_cache", useQueryCache);
		jpaProperties.setProperty("hibernate.cache.region.factory_class", regionFactoryClass);
		return jpaProperties;
	}

	/**
	 * {@inheritDoc}
	 */
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
}
