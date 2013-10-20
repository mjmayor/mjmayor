package org.mjmayor.jpa.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.validation.ConstraintViolationException;

import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.mjmayor.jpa.support.Criteria;

public interface DAO<ENTITY> {

	void add(ENTITY entity) throws ConstraintViolationException, JPAPersistenceException;

	void update(ENTITY entity) throws JPAPersistenceException;

	void remove(Long id);

	void remove(CriteriaQuery<ENTITY> criteriaQuery) throws JPAPersistenceException;

	ENTITY get(Long id);

	List<ENTITY> get(CriteriaQuery<ENTITY> criteriaQuery, Criteria criteria) throws JPAPersistenceException;

	Long count(CriteriaQuery<Long> criteriaQuery, Criteria criteria);
}
