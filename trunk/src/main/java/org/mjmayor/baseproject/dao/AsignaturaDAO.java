package org.mjmayor.baseproject.dao;

import java.util.List;

public interface AsignaturaDAO {
	public void addAsignatura(Asignatura asignatura);
	public List<Asignatura> getAsignaturas();
	public Asignatura getAsignatura(int id);
	public void removeAsignatura(int id);
}
