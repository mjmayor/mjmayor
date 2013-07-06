package org.mjmayor.jpa.facade;

import java.util.List;

import org.mjmayor.jpa.form.AlumnoForm;
import org.mjmayor.jpa.view.AlumnoView;

public interface AlumnoFacade {

	public void addAlumno(AlumnoForm alumno);

	public List<AlumnoView> getAlumnos();

	public AlumnoView getAlumno(AlumnoForm alumnoForm);

	public void removeAlumno(AlumnoForm alumnoForm);
}
