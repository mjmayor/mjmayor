package org.mjmayor.persistence.service.impl;

import java.util.List;

import org.mjmayor.jpa.assembler.BidirectionalAssembler;
import org.mjmayor.jpa.dao.DAO;
import org.mjmayor.jpa.service.impl.ServiceImpl;
import org.mjmayor.persistence.service.ProfesorService;

public class ProfesorServiceImpl<Profesor, ProfesorDTO> extends ServiceImpl<Profesor, ProfesorDTO> implements ProfesorService<Profesor, ProfesorDTO> {

	public ProfesorServiceImpl(DAO<Profesor> dao, BidirectionalAssembler<Profesor, ProfesorDTO> assembler) {
		super(dao, assembler);
	}

	public List<Profesor> getAlphabeticalList() {
		return null;
	}
}