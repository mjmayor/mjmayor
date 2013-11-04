package org.mjmayor.baseproject.facade;

import org.mjmayor.baseproject.view.ProfesorView;
import org.mjmayor.jpa.support.Criteria;
import org.mjmayor.jpa.support.Field;
import org.mjmayor.jpa.support.PageResult;
import org.mjmayor.model.dto.ProfesorDTO;

public interface ProfesorFacade {

	void add(ProfesorDTO profesorDTO);

	void update(ProfesorDTO profesorDTO);

	void delete(Long id);
	
	void delete(Field field);

	ProfesorView get(Long id);

	Long countAll();

	PageResult<ProfesorView> get(Criteria criteria);

	PageResult<ProfesorView> getByDNI(String dni);

	PageResult<ProfesorView> getLikeName(String name, Criteria criteria);

	PageResult<ProfesorView> getLikeSurname(String surname, Criteria criteria);

	PageResult<ProfesorView> getAlphabeticalList(Criteria criteria);
}
