package org.mjmayor.baseproject.facade.impl;

import org.mjmayor.baseproject.facade.AsignaturaFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsignaturaFacadeImpl implements AsignaturaFacade {

	private static final Logger logger = LoggerFactory.getLogger(AsignaturaFacadeImpl.class);

	private GenericService service;

	public AsignaturaFacadeImpl(GenericService service) {
		this.service = service;
	}
}
