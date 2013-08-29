package org.mjmayor.baseproject.facade.impl;

import org.mjmayor.baseproject.facade.ProfesorFacade;
import org.mjmayor.persistence.dto.ProfesorDTO;
import org.mjmayor.persistence.entity.Profesor;
import org.mjmayor.persistence.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfesorFacadeImpl implements ProfesorFacade {

	private static final Logger logger = LoggerFactory.getLogger(ProfesorFacadeImpl.class);

	private Service<Profesor, ProfesorDTO> service;

	public ProfesorFacadeImpl(Service<Profesor, ProfesorDTO> service) {
		this.service = service;
	}
}
