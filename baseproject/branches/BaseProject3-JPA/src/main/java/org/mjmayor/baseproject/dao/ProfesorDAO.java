package org.mjmayor.baseproject.dao;

import java.util.List;

import org.mjmayor.baseproject.dto.ProfesorDTO;
import org.mjmayor.baseproject.form.ProfesorForm;

public interface ProfesorDAO {
	public void addProfesor(ProfesorForm profesorForm);

	public List<ProfesorDTO> getProfesores();

	public ProfesorDTO getProfesor(ProfesorForm profesorForm);

	public void removeProfesor(ProfesorForm profesorForm);
}
