package org.mjmayor.baseproject.facade;

import java.util.List;

import org.mjmayor.baseproject.view.ProfesorView;
import org.mjmayor.jpa.support.Criteria;

public interface ProfesorFacade {

	Long countAll();

	ProfesorView get(Long id);

	List<ProfesorView> get(Criteria criteria);
}
