package org.mjmayor.baseproject.facade;

import java.util.List;

import org.prueba.universidad.model.Asignatura;

public interface AsignaturaFacade {
	public void addAsignatura(Asignatura asignatura);
	public List<Asignatura> getAsignaturas();
	public Asignatura getAsignatura(int id);
	public void removeAsignatura(int id);
}
