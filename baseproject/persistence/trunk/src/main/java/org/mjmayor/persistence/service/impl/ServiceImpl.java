package org.mjmayor.persistence.service.impl;

import javax.persistence.EntityManager;

import org.mjmayor.jpa.assembler.BidirectionalAssembler;
import org.mjmayor.jpa.service.impl.GenericServiceImpl;
import org.mjmayor.persistence.service.Service;

public class ServiceImpl<Profesor, ProfesorDTO> extends GenericServiceImpl<Profesor, ProfesorDTO> implements Service<Profesor, ProfesorDTO> {

	public ServiceImpl(EntityManager entityManager, BidirectionalAssembler<Profesor, ProfesorDTO> assembler) {
		super(entityManager, assembler);
	}
}
