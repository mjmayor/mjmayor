package org.mjmayor.baseproject.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.mjmayor.baseproject.assembler.AlumnoAssembler;
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

    private AlumnoAssembler alumnoAssembler;

    public AlumnoFacadeImpl(AlumnoDAO alumnoDAO, AlumnoAssembler alumnoAssembler) {
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
	List<AlumnoDTO> listaDTO = alumnoDAO.getAlumnos();
	List<AlumnoView> listaView = new ArrayList<AlumnoView>(alumnoAssembler.assemble(listaDTO));
	return listaView;
    }

    @Override
    @Transactional(readOnly = true)
    public AlumnoView getAlumno(AlumnoForm alumnoForm) {
	AlumnoDTO alumnoDTO = alumnoDAO.getAlumno(alumnoForm);
	AlumnoView alumnoView = alumnoAssembler.assemble(alumnoDTO);
	return alumnoView;
    }

    @Override
    @Transactional
    public void removeAlumno(AlumnoForm alumnoForm) {
	alumnoDAO.removeAlumno(alumnoForm);
    }
}
