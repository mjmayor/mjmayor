package org.mjmayor.baseproject.facade.impl;

import java.util.List;

import org.prueba.universidad.model.Profesor;
import org.prueba.universidad.model.dao.interfaces.ProfesorDAO;
import org.prueba.universidad.model.service.interfaces.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesorFacadeImpl implements ProfesorFacade {

    @Autowired
    private ProfesorDAO profesorDAO;

    @Override
    @Transactional
    public void addProfesor(Profesor profesor) {
	profesorDAO.addProfesor(profesor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Profesor> getProfesores() {
	return profesorDAO.getProfesores();
    }

    @Override
    @Transactional(readOnly = true)
    public Profesor getProfesor(int id) {
	return profesorDAO.getProfesor(id);
    }

    @Override
    @Transactional
    public void removeProfesor(int id) {
	profesorDAO.removeProfesor(id);
    }
}
