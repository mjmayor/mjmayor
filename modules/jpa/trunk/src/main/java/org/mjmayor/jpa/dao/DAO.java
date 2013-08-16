package org.mjmayor.jpa.dao;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;

public interface DAO<FORM, DTO> {

	public void add(DTO dto) throws ConstraintViolationException, JPAPersistenceException;

	public void removeById(int id) throws JPAPersistenceException;

	public void update(DTO dto) throws JPAPersistenceException;

	public void removeByField(String field, Object value) throws JPAPersistenceException, FieldNotFoundException;

	public void removeLikeField(String field, String value) throws JPAPersistenceException, FieldNotFoundException;

	public List<DTO> getAll();

	public DTO getById(int id);

	public List<DTO> getByField(String field, Object value) throws FieldNotFoundException;

	public List<DTO> getLikeField(String field, String value) throws FieldNotFoundException;

	public List<DTO> getLikeAllFields(FORM form) throws FieldNotFoundException;

	public long getTotal();
}
