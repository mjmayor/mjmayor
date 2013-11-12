package org.mjmayor.jpa.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.ConstraintViolationException;

import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.mjmayor.jpa.support.Criteria;
import org.mjmayor.jpa.support.PageResult;

public interface Repository<ENTITY extends Serializable> {

	CriteriaBuilder getCriteriaBuilder();

	void add(ENTITY entity) throws ConstraintViolationException, JPAPersistenceException;

	void update(ENTITY entity) throws JPAPersistenceException;

	void delete(Long id);

	void delete(List<ENTITY> entities) throws JPAPersistenceException;

	ENTITY get(Long id);

	PageResult<ENTITY> get(CriteriaQuery<ENTITY> criteriaQuery, Criteria criteria) throws JPAPersistenceException;

	PageResult<ENTITY> get(String hql, Criteria criteria) throws JPAPersistenceException;

	Long count(CriteriaQuery<Long> criteriaQuery, Criteria criteria);

	Long count(String hql, Criteria criteria);
}
