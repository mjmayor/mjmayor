package org.mjmayor.jpa.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.ConstraintViolationException;

import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.mjmayor.jpa.support.Criteria;
import org.mjmayor.jpa.support.Field;

public interface Service<ENTITY, DTO> {

	CriteriaBuilder getCriteriaBuilder();

	void add(DTO form) throws ConstraintViolationException, JPAPersistenceException;

	void update(DTO form) throws JPAPersistenceException;

	void remove(Long id);

	void removeByField(Field field) throws JPAPersistenceException, FieldNotFoundException;

	void removeLikeField(Field field) throws JPAPersistenceException, FieldNotFoundException;

	DTO get(Long id);

	List<DTO> get(CriteriaQuery<ENTITY> queryParams, Criteria criteria);

	Long count(CriteriaQuery<Long> queryParams, Criteria criteria);

	List<DTO> getByField(Field field, Criteria criteria) throws FieldNotFoundException;

	List<DTO> getLikeField(Field field, Criteria criteria) throws FieldNotFoundException;
}
