package org.mjmayor.baseproject.facade.impl;

import org.mjmayor.baseproject.dto.ProfesorDTO;
import org.mjmayor.baseproject.entity.Profesor;
import org.mjmayor.baseproject.facade.ProfesorFacade;
import org.mjmayor.jpa.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfesorFacadeImpl implements ProfesorFacade {

	private static final Logger logger = LoggerFactory.getLogger(ProfesorFacadeImpl.class);

	private Service<ProfesorDTO, Profesor> service;

	public ProfesorFacadeImpl(Service<ProfesorDTO, Profesor> service) {
		this.service = service;
	}
}
