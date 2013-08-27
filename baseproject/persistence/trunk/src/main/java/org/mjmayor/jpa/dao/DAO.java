package org.mjmayor.jpa.dao;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.hibernate.Criteria;
import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;

public interface DAO<ENTITY> {

	public void add(ENTITY entity) throws ConstraintViolationException, JPAPersistenceException;

	public void update(ENTITY entity) throws JPAPersistenceException;

	public void removeByField(String field, Object value) throws JPAPersistenceException, FieldNotFoundException;

	public void removeLikeField(String field, String value) throws JPAPersistenceException, FieldNotFoundException;

	public List<ENTITY> getAll();

	public long countAll();

	public List<ENTITY> getByField(String field, Object value) throws FieldNotFoundException;

	public List<ENTITY> getLikeField(String field, String value) throws FieldNotFoundException;

	public List<ENTITY> getByCriteria(Criteria criteria) throws JPAPersistenceException;
}
