package org.mjmayor.jpa.config.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;

import org.springframework.transaction.PlatformTransactionManager;

public interface PersistenceConfig {

	EntityManagerFactory entityManagerFactory();

	PlatformTransactionManager transactionManager();

	EntityManager entityManager();

	CriteriaBuilder criteriaBuilder();
}
