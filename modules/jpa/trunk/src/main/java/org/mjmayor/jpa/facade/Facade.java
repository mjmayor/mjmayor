package org.mjmayor.jpa.facade;

import java.util.List;

public interface Facade<FORM, VIEW> {

	public void add(FORM form);

	public void removeById(int id);

	public void removeByField(String field, Object value);

	public void removeLikeField(String field, Object value);

	public List<VIEW> getAll();

	public VIEW getById(int id);

	public List<VIEW> getByField(String field, Object value);

	public List<VIEW> getLikeField(String field, Object value);

	public List<VIEW> getLikeAllFields(FORM form);
}
