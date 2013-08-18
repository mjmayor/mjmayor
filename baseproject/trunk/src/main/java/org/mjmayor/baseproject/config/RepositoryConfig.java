package org.mjmayor.baseproject.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class RepositoryConfig {

	private static final String DIALECT_MYSQL = "org.hibernate.dialect.MySQLDialect";
	
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

	private DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(databaseUrl);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(dataSource());
		localContainerEntityManagerFactoryBean.setPackagesToScan("org.mjmayor.baseproject");
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		localContainerEntityManagerFactoryBean.afterPropertiesSet();
		return localContainerEntityManagerFactoryBean.getNativeEntityManagerFactory();
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(getDatabase(dialect));
		jpaVendorAdapter.setShowSql(Boolean.parseBoolean(hibernateShowSql));
		return jpaVendorAdapter;
	}

	/**
	 * Metodo para recuperar la base de datos a utilizar para un determinado dialecto <br/>
	 * TODO mjmayor Añadir nuevas BBDD conforme vayan haciendo falta
	 * 
	 * @param dialect
	 *            Dialecto a utilizar
	 * @return Base de datos que corresponde al dialecto a utilizar
	 */
	private Database getDatabase(String dialect) {
		switch (dialect) {
			case DIALECT_MYSQL:
				return Database.MYSQL;
			default:
				return null;
		}
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}

	@Bean
	@PersistenceContext
	public EntityManager entityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
