package org.mjmayor.baseproject.dao;

import java.util.List;

import org.mjmayor.baseproject.form.AlumnoForm;
import org.mjmayor.baseproject.view.AlumnoView;

public interface AlumnoDAO {
    public void addAlumno(AlumnoForm alumnoForm);

    public List<AlumnoView> getAlumnos();

    public AlumnoView getAlumno(AlumnoForm alumnoForm);

    public void removeAlumno(AlumnoForm alumno);
}
