package org.mjmayor.jpa.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.mjmayor.jpa.support.Criteria;
import org.mjmayor.jpa.support.Field;
import org.mjmayor.jpa.support.querybuilder.QueryParams;

public interface Service<ENTITY, DTO> {

	void add(DTO form) throws ConstraintViolationException, JPAPersistenceException;

	void update(DTO form) throws JPAPersistenceException;

	void removeByField(String field, Object value) throws JPAPersistenceException, FieldNotFoundException;

	void removeLikeField(String field, String value) throws JPAPersistenceException, FieldNotFoundException;

	Long count(QueryParams<ENTITY> queryParams, Criteria criteria);

	List<DTO> get(QueryParams<ENTITY> queryParams, Criteria criteria);

	DTO get(Long id);

	List<DTO> getByField(Field field, Criteria criteria) throws FieldNotFoundException;

	List<DTO> getLikeField(Field field, Criteria criteria) throws FieldNotFoundException;
}
