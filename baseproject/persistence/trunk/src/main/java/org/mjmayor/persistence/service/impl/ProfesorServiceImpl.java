package org.mjmayor.persistence.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.mjmayor.jpa.assembler.BidirectionalAssembler;
import org.mjmayor.jpa.service.impl.ServiceImpl;
import org.mjmayor.persistence.service.ProfesorService;

public class ProfesorServiceImpl<Profesor, ProfesorDTO> extends ServiceImpl<Profesor, ProfesorDTO> implements ProfesorService<Profesor, ProfesorDTO> {

	public ProfesorServiceImpl(EntityManager entityManager, BidirectionalAssembler<Profesor, ProfesorDTO> assembler) {
		super(entityManager, assembler);
	}
	
	public List<Profesor> getAlphabeticalList(){
		return null;
	}
}
