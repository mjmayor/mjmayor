package org.mjmayor.jpa.dao;

import java.util.List;

import org.mjmayor.jpa.dto.AlumnoDTO;
import org.mjmayor.jpa.form.AlumnoForm;

public interface AlumnoDAO {
	public void addAlumno(AlumnoForm alumnoForm);

	public List<AlumnoDTO> getAlumnos();

	public AlumnoDTO getAlumno(AlumnoForm alumnoForm);

	public void removeAlumno(AlumnoForm alumno);
}
