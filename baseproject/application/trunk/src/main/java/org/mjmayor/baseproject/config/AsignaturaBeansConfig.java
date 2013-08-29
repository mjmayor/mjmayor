package org.mjmayor.baseproject.config;

import org.hibernate.SessionFactory;
import org.mjmayor.baseproject.assembler.asignatura.AsignaturaFormAssembler;
import org.mjmayor.baseproject.assembler.asignatura.AsignaturaViewAssembler;
import org.mjmayor.baseproject.facade.AsignaturaFacade;
import org.mjmayor.baseproject.facade.impl.AsignaturaFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

//@Configuration
public class AsignaturaBeansConfig {

	@Autowired
	private SessionFactory sessionFactory;

	@Bean
	public AsignaturaFacade asignaturaFacade() {
		return new AsignaturaFacadeImpl(null);
	}

	@Bean
	public AsignaturaViewAssembler asignaturaViewAssembler() {
		return new AsignaturaViewAssembler();
	}

	@Bean
	public AsignaturaFormAssembler asignaturaFormAssembler() {
		return new AsignaturaFormAssembler();
	}
}
