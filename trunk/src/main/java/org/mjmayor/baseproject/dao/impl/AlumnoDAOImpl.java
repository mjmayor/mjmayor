package org.mjmayor.baseproject.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.mjmayor.baseproject.assembler.alumno.AlumnoFormAssembler;
import org.mjmayor.baseproject.dao.AlumnoDAO;
import org.mjmayor.baseproject.dto.AlumnoDTO;
import org.mjmayor.baseproject.form.AlumnoForm;
import org.mjmayor.baseproject.utils.ListUtils;

public class AlumnoDAOImpl implements AlumnoDAO {

    private SessionFactory sessionFactory;
    
    private AlumnoFormAssembler alumnoFormAssembler;

    public AlumnoDAOImpl(SessionFactory sessionFactory, AlumnoFormAssembler alumnoFormAssembler) {
	this.sessionFactory = sessionFactory;
	this.alumnoFormAssembler=alumnoFormAssembler;
    }

    @Override
    public void addAlumno(AlumnoForm alumnoForm) {
	AlumnoDTO alumnoDTO = alumnoFormAssembler.assemble(alumnoForm);
	sessionFactory.getCurrentSession().save(alumnoDTO);
    }

    @Override
    public List<AlumnoDTO> getAlumnos() {
	return ListUtils.castList(AlumnoDTO.class, sessionFactory.getCurrentSession().createQuery("from AlumnoDTO").list());
    }

    @Override
    public AlumnoDTO getAlumno(AlumnoForm alumnoForm) {
	return (AlumnoDTO) sessionFactory.getCurrentSession().get(AlumnoDTO.class, alumnoForm.getDni());
    }

    @Override
    public void removeAlumno(AlumnoForm alumnoForm) {
	AlumnoDTO alumno = (AlumnoDTO) sessionFactory.getCurrentSession().load(AlumnoDTO.class, alumnoForm.getDni());
	if (alumno != null) {
	    sessionFactory.getCurrentSession().delete(alumno);
	}
    }
}
