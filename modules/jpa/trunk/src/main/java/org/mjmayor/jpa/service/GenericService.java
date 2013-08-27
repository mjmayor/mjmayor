package org.mjmayor.jpa.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.hibernate.Criteria;
import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;

public interface GenericService<ENTITY, DTO> {

	public void add(DTO form) throws ConstraintViolationException, JPAPersistenceException;

	public void update(DTO form) throws JPAPersistenceException;

	public void removeByField(String field, Object value) throws JPAPersistenceException, FieldNotFoundException;

	public void removeLikeField(String field, String value) throws JPAPersistenceException, FieldNotFoundException;

	public List<DTO> getAll();

	public long countAll();

	public List<DTO> getByField(String field, Object value) throws FieldNotFoundException;

	public List<DTO> getLikeField(String field, String value) throws FieldNotFoundException;

	public List<DTO> getByCriteria(Criteria criteria) throws FieldNotFoundException;
}
