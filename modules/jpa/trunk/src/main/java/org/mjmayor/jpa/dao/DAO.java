package org.mjmayor.jpa.dao;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.hibernate.Criteria;
import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;

public interface DAO<ENTITY> {

	void add(ENTITY entity) throws ConstraintViolationException, JPAPersistenceException;

	void update(ENTITY entity) throws JPAPersistenceException;

	void removeByField(String field, Object value) throws JPAPersistenceException, FieldNotFoundException;

	void removeLikeField(String field, String value) throws JPAPersistenceException, FieldNotFoundException;

	List<ENTITY> getAll();

	long countAll();

	List<ENTITY> getByField(String field, Object value) throws FieldNotFoundException;

	List<ENTITY> getLikeField(String field, String value) throws FieldNotFoundException;

	List<ENTITY> getByCriteria(Criteria criteria) throws JPAPersistenceException;
}
