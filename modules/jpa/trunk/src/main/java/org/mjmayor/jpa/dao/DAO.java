package org.mjmayor.jpa.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.ConstraintViolationException;

import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.mjmayor.jpa.support.Criteria;
import org.mjmayor.jpa.support.PageResult;

public interface DAO<ENTITY extends Serializable> {

	CriteriaBuilder getCriteriaBuilder();

	void add(ENTITY entity) throws ConstraintViolationException, JPAPersistenceException;

	void update(ENTITY entity) throws JPAPersistenceException;

	void remove(Long id);

	void remove(List<ENTITY> entities) throws JPAPersistenceException;

	ENTITY get(Long id);

	PageResult<ENTITY> get(CriteriaQuery<ENTITY> criteriaQuery, Criteria criteria) throws JPAPersistenceException;

	Long count(CriteriaQuery<Long> criteriaQuery, Criteria criteria);
}
