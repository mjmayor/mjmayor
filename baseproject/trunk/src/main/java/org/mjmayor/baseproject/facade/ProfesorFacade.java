package org.mjmayor.baseproject.facade;

import java.util.List;

import org.mjmayor.baseproject.form.ProfesorForm;
import org.mjmayor.baseproject.view.ProfesorView;

public interface ProfesorFacade {

	public void addProfesor(ProfesorForm profesorForm);

	public List<ProfesorView> getProfesores();

	public ProfesorView getProfesor(ProfesorForm profesorForm);

	public void removeProfesor(ProfesorForm profesorForm);
}
