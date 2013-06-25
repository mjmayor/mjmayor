package org.mjmayor.baseproject.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.mjmayor.baseproject.assembler.alumno.AlumnoViewAssembler;
import org.mjmayor.baseproject.dao.AlumnoDAO;
import org.mjmayor.baseproject.dto.AlumnoDTO;
import org.mjmayor.baseproject.facade.AlumnoFacade;
import org.mjmayor.baseproject.form.AlumnoForm;
import org.mjmayor.baseproject.view.AlumnoView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

public class AlumnoFacadeImpl implements AlumnoFacade {

	private static final Logger logger = LoggerFactory.getLogger(AlumnoFacadeImpl.class);

	private AlumnoDAO alumnoDAO;

	private AlumnoViewAssembler alumnoViewAssembler;

	public AlumnoFacadeImpl(AlumnoDAO alumnoDAO, AlumnoViewAssembler alumnoAssembler) {
		super();
		this.alumnoDAO = alumnoDAO;
		this.alumnoViewAssembler = alumnoAssembler;
	}

	@Override
	@Transactional
	public void addAlumno(AlumnoForm alumno) {

		logger.debug("AlumnoFacadeImpl - addAlumno");

		alumnoDAO.addAlumno(alumno);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AlumnoView> getAlumnos() {

		logger.debug("AlumnoFacadeImpl - getAlumnos");

		List<AlumnoDTO> listaDTO = alumnoDAO.getAlumnos();
		List<AlumnoView> listaView = new ArrayList<AlumnoView>(alumnoViewAssembler.assemble(listaDTO));
		return listaView;
	}

	@Override
	@Transactional(readOnly = true)
	public AlumnoView getAlumno(AlumnoForm alumnoForm) {

		logger.debug("AlumnoFacadeImpl - getAlumno");

		AlumnoDTO alumnoDTO = alumnoDAO.getAlumno(alumnoForm);
		AlumnoView alumnoView = alumnoViewAssembler.assemble(alumnoDTO);
		return alumnoView;
	}

	@Override
	@Transactional
	public void removeAlumno(AlumnoForm alumnoForm) {

		logger.debug("AlumnoFacadeImpl - removeAlumno");

		alumnoDAO.removeAlumno(alumnoForm);
	}
}
