package org.mjmayor.baseproject.facade.impl;

import org.mjmayor.baseproject.facade.ProfesorFacade;
import org.mjmayor.model.dto.ProfesorDTO;
import org.mjmayor.model.entity.Profesor;
import org.mjmayor.persistence.service.ProfesorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfesorFacadeImpl implements ProfesorFacade {

	private static final Logger logger = LoggerFactory.getLogger(ProfesorFacadeImpl.class);

	private ProfesorService<Profesor, ProfesorDTO> service;

	public ProfesorFacadeImpl(ProfesorService<Profesor, ProfesorDTO> service) {
		this.service = service;
	}
}
