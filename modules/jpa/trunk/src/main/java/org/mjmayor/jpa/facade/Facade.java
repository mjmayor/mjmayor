package org.mjmayor.jpa.facade;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;

public interface Facade<FORM, DTO, VIEW> {

	public void add(FORM form) throws ConstraintViolationException, JPAPersistenceException;

	public void removeById(int id) throws JPAPersistenceException;

	public void update(FORM form) throws JPAPersistenceException;

	public void removeByField(String field, Object value) throws JPAPersistenceException, FieldNotFoundException;

	public void removeLikeField(String field, String value) throws JPAPersistenceException, FieldNotFoundException;

	public List<VIEW> getAll();

	public VIEW getById(int id);

	public List<VIEW> getByField(String field, Object value) throws FieldNotFoundException;

	public List<VIEW> getLikeField(String field, String value) throws FieldNotFoundException;

	public List<VIEW> getLikeAllFields(FORM form) throws FieldNotFoundException;

	public long getTotal();
}
