package org.mjmayor.baseproject.dao;

import java.util.List;

import org.mjmayor.baseproject.dto.AsignaturaDTO;
import org.mjmayor.baseproject.form.AsignaturaForm;

public interface AsignaturaDAO {
    public void addAsignatura(AsignaturaForm asignaturaForm);

    public List<AsignaturaDTO> getAsignaturas();

    public AsignaturaDTO getAsignatura(AsignaturaForm asignaturaForm);

    public void removeAsignatura(AsignaturaForm asignaturaForm);
}
