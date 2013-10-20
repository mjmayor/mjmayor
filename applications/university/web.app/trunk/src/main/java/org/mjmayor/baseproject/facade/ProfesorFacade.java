package org.mjmayor.baseproject.facade;

import java.util.List;

import org.mjmayor.baseproject.form.ProfesorForm;
import org.mjmayor.baseproject.view.ProfesorView;
import org.mjmayor.jpa.support.Criteria;

public interface ProfesorFacade {

	void add(ProfesorForm form);

	void update(ProfesorForm form);

	void remove(Long id);

	ProfesorView get(Long id);

	Long countAll();

	List<ProfesorView> get(Criteria criteria);

	List<ProfesorView> getByDNI(String dni);

	List<ProfesorView> getLikeName(String name, Criteria criteria);

	List<ProfesorView> getLikeSurname(String surname, Criteria criteria);

	List<ProfesorView> getAlphabeticalList(Criteria criteria);
}
