package org.mjmayor.jpa.service;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.validation.ConstraintViolationException;

import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.mjmayor.jpa.support.Criteria;

public interface Service<ENTITY, DTO> {

	void add(DTO form) throws ConstraintViolationException, JPAPersistenceException;

	void update(DTO form) throws JPAPersistenceException;

	void removeByField(String field, Object value) throws JPAPersistenceException, FieldNotFoundException;

	void removeLikeField(String field, String value) throws JPAPersistenceException, FieldNotFoundException;

	Long countAll();

	DTO get(Long id);

	List<DTO> get(Criteria criteria);

	List<DTO> getByField(String field, Object value, Criteria criteria) throws FieldNotFoundException;

	List<DTO> getLikeField(String field, String value, Criteria criteria) throws FieldNotFoundException;

	List<DTO> get(CriteriaQuery<ENTITY> criteriaQuery, Criteria criteria);
}
