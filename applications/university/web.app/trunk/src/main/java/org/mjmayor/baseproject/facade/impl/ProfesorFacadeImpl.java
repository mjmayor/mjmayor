package org.mjmayor.baseproject.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.mjmayor.baseproject.assembler.profesor.ProfesorViewAssembler;
import org.mjmayor.baseproject.constants.ProfesorConstants;
import org.mjmayor.baseproject.facade.ProfesorFacade;
import org.mjmayor.baseproject.view.ProfesorView;
import org.mjmayor.jpa.service.Service;
import org.mjmayor.jpa.support.Criteria;
import org.mjmayor.jpa.support.Field;
import org.mjmayor.model.dto.ProfesorDTO;
import org.mjmayor.model.entity.Profesor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfesorFacadeImpl implements ProfesorFacade {

	private static final Logger logger = LoggerFactory.getLogger(ProfesorFacadeImpl.class);

	private Service<Profesor, ProfesorDTO> service;

	private ProfesorViewAssembler assembler;

	public ProfesorFacadeImpl(Service<Profesor, ProfesorDTO> service, ProfesorViewAssembler assembler) {
		this.service = service;
		this.assembler = assembler;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long countAll() {
		return service.countAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProfesorView get(Long id) {
		ProfesorDTO dto = service.get(id);
		return assembler.assemble(dto);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ProfesorView> get(Criteria criteria) {
		List<ProfesorDTO> list = service.get(criteria);
		return new ArrayList<ProfesorView>(assembler.assemble(list));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ProfesorView> getByDNI(String dni) {
		List<ProfesorDTO> list = service.getByField(new Field(ProfesorConstants.Fields.DNI, dni), null);
		return new ArrayList<ProfesorView>(assembler.assemble(list));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ProfesorView> getLikeName(String name, Criteria criteria) {
		List<ProfesorDTO> list = service.getLikeField(new Field(ProfesorConstants.Fields.NAME, name), criteria);
		return new ArrayList<ProfesorView>(assembler.assemble(list));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ProfesorView> getLikeSurname(String surname, Criteria criteria) {
		List<ProfesorDTO> list = service.getLikeField(new Field(ProfesorConstants.Fields.SURNAME, surname), criteria);
		return new ArrayList<ProfesorView>(assembler.assemble(list));
	}
}
