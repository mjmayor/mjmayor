package org.mjmayor.baseproject.dao;

import java.util.List;

public interface ProfesorDAO {
    public void addProfesor(Profesor profesor);

    public List<Profesor> getProfesores();

    public Profesor getProfesor(int id);

    public void removeProfesor(int id);
}
