package org.mjmayor.jpa.dao;

import java.util.List;

public interface DAO<FORM, DTO> {

	public void add(FORM form);

	public void removeById(int id);

	public void removeByField(String field, Object value);
	
	public void removeLikeField(String field, Object value);

	public List<DTO> getAll();

	public DTO getById(int id);

	public List<DTO> getByField(String field, Object value);

	public List<DTO> getLikeField(String field, Object value);

	public List<DTO> getLikeAllFields(FORM form);
}
