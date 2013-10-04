package org.mjmayor.baseproject.facade.impl;

import org.mjmayor.baseproject.facade.AlumnoFacade;
import org.mjmayor.persistence.service.ProfesorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlumnoFacadeImpl implements AlumnoFacade {

	private static final Logger logger = LoggerFactory.getLogger(AlumnoFacadeImpl.class);

	private ProfesorService service;

	public AlumnoFacadeImpl(ProfesorService service) {
		this.service = service;
	}
}
