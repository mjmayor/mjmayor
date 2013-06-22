package org.mjmayor.baseproject.dao;

import java.util.List;

import org.mjmayor.baseproject.dto.AlumnoDTO;
import org.mjmayor.baseproject.form.AlumnoForm;

public interface AlumnoDAO {
    public void addAlumno(AlumnoForm alumnoForm);

    public List<AlumnoDTO> getAlumnos();

    public AlumnoDTO getAlumno(AlumnoForm alumnoForm);

    public void removeAlumno(AlumnoForm alumno);
}
