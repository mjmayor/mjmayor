package org.mjmayor.jpa.dao;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.mjmayor.jpa.support.Criteria;
import org.mjmayor.jpa.support.querybuilder.QueryParams;

public interface DAO<ENTITY> {

	void add(ENTITY entity) throws ConstraintViolationException, JPAPersistenceException;

	void update(ENTITY entity) throws JPAPersistenceException;

	void remove(QueryParams<ENTITY> queryParams) throws JPAPersistenceException;

	ENTITY get(Long id);

	List<ENTITY> get(QueryParams<ENTITY> queryParams, Criteria criteria) throws JPAPersistenceException;

	Long count(QueryParams<ENTITY> queryParams, Criteria criteria);
}
