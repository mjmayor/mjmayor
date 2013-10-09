package org.mjmayor.baseproject.facade.impl;

import org.mjmayor.baseproject.facade.AsignaturaFacade;
import org.mjmayor.jpa.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsignaturaFacadeImpl implements AsignaturaFacade {

	private static final Logger logger = LoggerFactory.getLogger(AsignaturaFacadeImpl.class);

	private Service service;

	public AsignaturaFacadeImpl(Service service) {
		this.service = service;
	}
}
