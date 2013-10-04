package org.mjmayor.baseproject.facade.impl;

import org.mjmayor.baseproject.assembler.profesor.ProfesorViewAssembler;
import org.mjmayor.baseproject.facade.ProfesorFacade;
import org.mjmayor.baseproject.view.ProfesorView;
import org.mjmayor.model.dto.ProfesorDTO;
import org.mjmayor.model.entity.Profesor;
import org.mjmayor.persistence.service.ProfesorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfesorFacadeImpl implements ProfesorFacade {

	private static final Logger logger = LoggerFactory.getLogger(ProfesorFacadeImpl.class);

	private ProfesorService<Profesor, ProfesorDTO> service;

	private ProfesorViewAssembler assembler;

	public ProfesorFacadeImpl(ProfesorService<Profesor, ProfesorDTO> service, ProfesorViewAssembler assembler) {
		this.service = service;
		this.assembler = assembler;
	}

	@Override
	public Long countAll() {
		return service.countAll();
	}

	@Override
	public ProfesorView get(Long id) {
		ProfesorDTO dto = service.get(id);
		return assembler.assemble(dto);
	}
}
