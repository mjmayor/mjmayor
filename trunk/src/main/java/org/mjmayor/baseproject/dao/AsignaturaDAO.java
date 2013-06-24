package org.mjmayor.baseproject.dao;

import java.util.List;

import org.mjmayor.baseproject.dto.AsignaturaDTO;
import org.mjmayor.baseproject.form.AsignaturaForm;

public interface AsignaturaDAO {
	public void addAsignatura(AsignaturaForm asignaturaForm);

	public List<AsignaturaDTO> getAsignaturas();

	public List<AsignaturaDTO> getAsignaturasByField(String field, Object value);

	public List<AsignaturaDTO> getAsignaturasLikeField(String field, Object value);

	public List<AsignaturaDTO> getAsignaturas(AsignaturaForm Asignatura);

	public void removeAsignatura(AsignaturaForm asignaturaForm);
}
