package org.mjmayor.baseproject.facade;

import org.mjmayor.baseproject.view.AlumnoView;
import org.mjmayor.jpa.support.Criteria;
import org.mjmayor.jpa.support.Field;
import org.mjmayor.jpa.support.PageResult;
import org.mjmayor.model.dto.AlumnoDTO;

public interface AlumnoFacade {

	void add(AlumnoDTO alumnoDTO);

	void update(AlumnoDTO alumnoDTO);

	void delete(Long id);
	
	void delete(Field field);

	AlumnoView get(Long id);

	Long countAll();

	PageResult<AlumnoView> get(Criteria criteria);

	PageResult<AlumnoView> getByDNI(String dni);

	PageResult<AlumnoView> getLikeName(String name, Criteria criteria);

	PageResult<AlumnoView> getLikeSurname(String surname, Criteria criteria);

	PageResult<AlumnoView> getAlphabeticalList(Criteria criteria);
}
