package org.mjmayor.jpa.config.database;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.transaction.PlatformTransactionManager;

public interface RepositoryConfig {

	EntityManagerFactory entityManagerFactory();

	Database getDatabase(String dialect);

	PlatformTransactionManager transactionManager();

	DataSource dataSource();

	JpaVendorAdapter jpaVendorAdapter();
}
