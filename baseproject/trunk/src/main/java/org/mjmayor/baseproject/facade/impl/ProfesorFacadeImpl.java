package org.mjmayor.baseproject.facade.impl;

import org.mjmayor.baseproject.assembler.profesor.ProfesorFormAssembler;
import org.mjmayor.baseproject.assembler.profesor.ProfesorViewAssembler;
import org.mjmayor.baseproject.dao.ProfesorDAO;
import org.mjmayor.baseproject.dto.ProfesorDTO;
import org.mjmayor.baseproject.facade.ProfesorFacade;
import org.mjmayor.baseproject.form.ProfesorForm;
import org.mjmayor.baseproject.view.ProfesorView;
import org.mjmayor.jpa.facade.impl.FacadeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfesorFacadeImpl extends FacadeImpl<ProfesorForm, ProfesorDTO, ProfesorView> implements ProfesorFacade {

	private static final Logger logger = LoggerFactory.getLogger(ProfesorFacadeImpl.class);

	public ProfesorFacadeImpl(ProfesorDAO profesorDAO, ProfesorFormAssembler profesorFormAssembler, ProfesorViewAssembler profesorViewAssembler) {
		super(profesorDAO, profesorFormAssembler, profesorViewAssembler);
	}
}
