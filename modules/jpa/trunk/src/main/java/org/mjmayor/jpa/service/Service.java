package org.mjmayor.jpa.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.ConstraintViolationException;

import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.mjmayor.jpa.support.Criteria;
import org.mjmayor.jpa.support.Field;
import org.mjmayor.jpa.support.PageResult;

public interface Service<ENTITY, DTO> {

	CriteriaBuilder getCriteriaBuilder();

	void add(DTO form) throws ConstraintViolationException, JPAPersistenceException;

	void update(DTO form) throws JPAPersistenceException;

	void remove(Long id);

	void remove(Field field) throws JPAPersistenceException, FieldNotFoundException;

	void removeLike(Field field) throws JPAPersistenceException, FieldNotFoundException;

	DTO get(Long id);

	PageResult<DTO> get(CriteriaQuery<ENTITY> queryParams, Criteria criteria);

	PageResult<DTO> get(Field field, Criteria criteria) throws FieldNotFoundException;

	PageResult<DTO> getLike(Field field, Criteria criteria) throws FieldNotFoundException;

	Long count(CriteriaQuery<Long> queryParams, Criteria criteria);
}
