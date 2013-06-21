package org.mjmayor.baseproject.facade;

import java.util.List;

import org.mjmayor.baseproject.form.AlumnoForm;
import org.mjmayor.baseproject.view.AlumnoView;

public interface AlumnoFacade {
	public void addAlumno(AlumnoForm alumno);
	public List<AlumnoView> getAlumnos();
	public AlumnoView getAlumno(AlumnoForm alumnoForm);
	public void removeAlumno(AlumnoForm alumnoForm);
}
