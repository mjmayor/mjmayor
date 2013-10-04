package org.mjmayor.baseproject.facade.impl;

import org.mjmayor.baseproject.facade.AsignaturaFacade;
import org.mjmayor.persistence.service.ProfesorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsignaturaFacadeImpl implements AsignaturaFacade {

	private static final Logger logger = LoggerFactory.getLogger(AsignaturaFacadeImpl.class);

	private ProfesorService service;

	public AsignaturaFacadeImpl(ProfesorService service) {
		this.service = service;
	}
}
