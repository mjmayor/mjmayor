package org.mjmayor.baseproject.facade;

import org.mjmayor.baseproject.view.AsignaturaView;
import org.mjmayor.jpa.support.Criteria;
import org.mjmayor.jpa.support.Field;
import org.mjmayor.jpa.support.PageResult;
import org.mjmayor.model.dto.AsignaturaDTO;

public interface AsignaturaFacade {

	void add(AsignaturaDTO asignaturaDTO);

	void update(AsignaturaDTO asignaturaDTO);

	void delete(Long id);

	void delete(Field field);

	AsignaturaView get(Long id);

	Long countAll();

	PageResult<AsignaturaView> get(Criteria criteria);

	PageResult<AsignaturaView> getByCode(String code);

	PageResult<AsignaturaView> getAlphabeticalList(Criteria criteria);
}
