package org.mjmayor.jpa.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.transaction.PlatformTransactionManager;

public interface RepositoryConfig {

	public EntityManagerFactory entityManagerFactory();

	public Database getDatabase(String dialect);

	public PlatformTransactionManager transactionManager();

	public DataSource dataSource();

	public JpaVendorAdapter jpaVendorAdapter();
}
