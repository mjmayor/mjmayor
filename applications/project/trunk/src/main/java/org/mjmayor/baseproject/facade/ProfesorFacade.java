package org.mjmayor.baseproject.facade;

import org.mjmayor.baseproject.view.ProfesorView;

public interface ProfesorFacade {

	Long countAll();

	ProfesorView get(Long id);
}
