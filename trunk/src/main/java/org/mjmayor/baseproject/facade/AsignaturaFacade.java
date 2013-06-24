package org.mjmayor.baseproject.facade;

import java.util.List;

import org.mjmayor.baseproject.form.AsignaturaForm;

public interface AsignaturaFacade {
    public void addAsignatura(AsignaturaForm asignaturaForm);

    public List<AsignaturaView> getAsignaturas();

    public AsignaturaView getAsignaturaByCod(AsignaturaForm asignaturaForm);
    public AsignaturaView getAsignaturaByName(AsignaturaForm asignaturaForm);

    public void removeAsignatura(AsignaturaForm asignaturaForm);
}
