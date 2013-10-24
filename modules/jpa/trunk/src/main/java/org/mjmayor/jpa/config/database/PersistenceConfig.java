package org.mjmayor.jpa.config.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.mjmayor.jpa.config.database.support.Dialects;
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
public class PersistenceConfig extends WebMvcConfigurerAdapter {

	@Value("${repository.packagesToScan}")
	private String packagesToScan;
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.dialect}")
	private String dialect;
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

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	private DataSource dataSource;

	private Map<String, Database> databases;

	private EntityManager entityManager;

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

	private void initDataSource() {
		if (dataSource == null) {
			dataSource = dataSource();
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

	/**
	 * {@inheritDoc}
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		initDataSource();
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(dataSource);
		localContainerEntityManagerFactoryBean.setPackagesToScan(getPackagesToScan(packagesToScan));
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		localContainerEntityManagerFactoryBean.setJpaProperties(jpaProperties());
		localContainerEntityManagerFactoryBean.afterPropertiesSet();
		return localContainerEntityManagerFactoryBean.getNativeEntityManagerFactory();
	}

	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(getDatabase(dialect));
		jpaVendorAdapter.setShowSql(Boolean.parseBoolean(hibernateShowSql));
		return jpaVendorAdapter;
	}

	private Properties jpaProperties() {
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.cache.use_second_level_cache", useSecondLevelCache);
		jpaProperties.setProperty("hibernate.cache.provider_class", cacheProviderClass);
		jpaProperties.setProperty("hibernate.cache.use_query_cache", useQueryCache);
		jpaProperties.setProperty("hibernate.cache.region.factory_class", regionFactoryClass);
		return jpaProperties;
	}

	/**
	 * {@inheritDoc}
	 */
	@Bean(name = "transactionManager")
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
	@Bean(name = "entityManager")
	public EntityManager entityManager() {
		if (entityManager == null) {
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
}
