package org.mjmayor.baseproject.facade.impl;

import java.util.List;

import org.mjmayor.baseproject.assembler.AlumnoAssembler;
import org.mjmayor.baseproject.dao.AlumnoDAO;
import org.mjmayor.baseproject.facade.AlumnoFacade;
import org.mjmayor.baseproject.form.AlumnoForm;
import org.mjmayor.baseproject.view.AlumnoView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

public class AlumnoFacadeImpl implements AlumnoFacade {

	private static final Logger logger = LoggerFactory.getLogger(AlumnoFacadeImpl.class);
	
	private AlumnoDAO alumnoDAO;
	
	private AlumnoAssembler alumnoAssembler;
	
	public AlumnoFacadeImpl(AlumnoDAO alumnoDAO, AlumnoAssembler alumnoAssembler){
		super();
		this.alumnoDAO = alumnoDAO;
		this.alumnoAssembler = alumnoAssembler;
	}
	
	
	@Override
	@Transactional
	public void addAlumno(AlumnoForm alumno) {
		alumnoDAO.addAlumno(alumno);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AlumnoView> getAlumnos() {
		//Recuperar lista de AlumnoDTO y transformar a lista de AlumnoView
		return alumnoDAO.getAlumnos();
	}

	@Override
	@Transactional(readOnly = true)
	public AlumnoView getAlumno(AlumnoForm alumnoForm) {
		//Recuperar AlumnoDTO y transformar a AlumnoView
		return alumnoDAO.getAlumno(id);
	}

	@Override
	@Transactional
	public void removeAlumno(AlumnoForm alumnoForm) {
		alumnoDAO.removeAlumno(id);
	}
}
