package org.mjmayor.baseproject.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.mjmayor.baseproject.assembler.profesor.ProfesorViewAssembler;
import org.mjmayor.baseproject.dao.ProfesorDAO;
import org.mjmayor.baseproject.dto.ProfesorDTO;
import org.mjmayor.baseproject.facade.ProfesorFacade;
import org.mjmayor.baseproject.form.ProfesorForm;
import org.mjmayor.baseproject.view.ProfesorView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

public class ProfesorFacadeImpl implements ProfesorFacade {

	private static final Logger logger = LoggerFactory.getLogger(ProfesorFacadeImpl.class);

	private ProfesorDAO profesorDAO;

	private ProfesorViewAssembler profesorViewAssembler;

	public ProfesorFacadeImpl(ProfesorDAO profesorDAO, ProfesorViewAssembler profesorAssembler) {
		super();
		this.profesorDAO = profesorDAO;
		this.profesorViewAssembler = profesorAssembler;
	}

	@Override
	@Transactional
	public void addProfesor(ProfesorForm profesor) {
		logger.debug("ProfesorFacadeImpl - addProfesor");
		profesorDAO.addProfesor(profesor);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProfesorView> getProfesores() {
		logger.debug("ProfesorFacadeImpl - getProfesores");
		List<ProfesorDTO> listaDTO = profesorDAO.getProfesores();
		List<ProfesorView> listaView = new ArrayList<ProfesorView>(profesorViewAssembler.assemble(listaDTO));
		return listaView;
	}

	@Override
	@Transactional(readOnly = true)
	public ProfesorView getProfesor(ProfesorForm profesorForm) {
		logger.debug("ProfesorFacadeImpl - getProfesor");
		ProfesorDTO profesorDTO = profesorDAO.getProfesor(profesorForm);
		ProfesorView profesorView = profesorViewAssembler.assemble(profesorDTO);
		return profesorView;
	}

	@Override
	@Transactional
	public void removeProfesor(ProfesorForm profesorForm) {
		logger.debug("ProfesorFacadeImpl - removeProfesor");
		profesorDAO.removeProfesor(profesorForm);
	}
}
