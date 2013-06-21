package org.mjmayor.baseproject.facade;

import java.util.List;

import org.prueba.universidad.model.Profesor;

public interface ProfesorFacade {
	public void addProfesor(Profesor profesor);
	public List<Profesor> getProfesores();
	public Profesor getProfesor(int id);
	public void removeProfesor(int id);
}
