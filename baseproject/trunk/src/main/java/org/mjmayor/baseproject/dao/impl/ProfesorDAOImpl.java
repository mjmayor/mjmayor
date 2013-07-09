package org.mjmayor.baseproject.dao.impl;

import javax.persistence.EntityManager;

import org.mjmayor.baseproject.assembler.profesor.ProfesorFormAssembler;
import org.mjmayor.baseproject.dao.ProfesorDAO;
import org.mjmayor.baseproject.dto.ProfesorDTO;
import org.mjmayor.baseproject.form.ProfesorForm;
import org.mjmayor.jpa.dao.impl.DAOImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfesorDAOImpl extends DAOImpl<ProfesorForm, ProfesorDTO> implements ProfesorDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProfesorDAOImpl.class);

	public ProfesorDAOImpl(EntityManager entityManager, ProfesorFormAssembler profesorFormAssembler) {
		super(entityManager, profesorFormAssembler);
	}
}
