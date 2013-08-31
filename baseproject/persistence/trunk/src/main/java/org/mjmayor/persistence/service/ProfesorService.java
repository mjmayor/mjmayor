package org.mjmayor.persistence.service;

import java.util.List;

import org.mjmayor.jpa.service.Service;

public interface ProfesorService<Profesor, ProfesorDTO> extends Service<Profesor, ProfesorDTO> {

	public List<Profesor> getAlphabeticalList();
}
