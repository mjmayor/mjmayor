package org.mjmayor.baseproject.facade.impl;

import org.mjmayor.baseproject.facade.AlumnoFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlumnoFacadeImpl implements AlumnoFacade {

	private static final Logger logger = LoggerFactory.getLogger(AlumnoFacadeImpl.class);

	private GenericService service;

	public AlumnoFacadeImpl(GenericService service) {
		this.service = service;
	}
}
