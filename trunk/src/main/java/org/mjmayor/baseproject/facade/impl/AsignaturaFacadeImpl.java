package org.mjmayor.baseproject.facade.impl;

import java.util.List;

import org.prueba.universidad.model.Asignatura;
import org.prueba.universidad.model.dao.interfaces.AsignaturaDAO;
import org.prueba.universidad.model.service.interfaces.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AsignaturaFacadeImpl implements AsignaturaFacade {

	@Autowired
	private AsignaturaDAO asignaturaDAO;
	
	
	@Override
	@Transactional
	public void addAsignatura(Asignatura asignatura) {
		asignaturaDAO.addAsignatura(asignatura);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asignatura> getAsignaturas() {
		return asignaturaDAO.getAsignaturas();
	}

	@Override
	@Transactional(readOnly = true)
	public Asignatura getAsignatura(int id) {
		return asignaturaDAO.getAsignatura(id);
	}

	@Override
	@Transactional
	public void removeAsignatura(int id) {
		asignaturaDAO.removeAsignatura(id);
	}
}
