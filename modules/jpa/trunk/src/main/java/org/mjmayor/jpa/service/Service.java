package org.mjmayor.jpa.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.hibernate.Criteria;
import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;

public interface Service<ENTITY, DTO> {

	void add(DTO form) throws ConstraintViolationException, JPAPersistenceException;

	void update(DTO form) throws JPAPersistenceException;

	void removeByField(String field, Object value) throws JPAPersistenceException, FieldNotFoundException;

	void removeLikeField(String field, String value) throws JPAPersistenceException, FieldNotFoundException;

	List<DTO> getAll();

	long countAll();

	List<DTO> getByField(String field, Object value) throws FieldNotFoundException;

	List<DTO> getLikeField(String field, String value) throws FieldNotFoundException;

	List<DTO> getByCriteria(Criteria criteria) throws FieldNotFoundException;
}
