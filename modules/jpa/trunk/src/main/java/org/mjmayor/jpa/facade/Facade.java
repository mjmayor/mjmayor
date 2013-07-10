package org.mjmayor.jpa.facade;

import java.util.List;

public interface Facade<FORM, DTO, VIEW> {

	public void add(FORM form) throws Exception;

	public void removeById(int id);

	public void removeByField(String field, Object value);

	public void removeLikeField(String field, String value);

	public List<VIEW> getAll();

	public VIEW getById(int id);

	public List<VIEW> getByField(String field, Object value);

	public List<VIEW> getLikeField(String field, String value);

	public List<VIEW> getLikeAllFields(FORM form);
}
