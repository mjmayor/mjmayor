package org.mjmayor.baseproject.config;

import org.hibernate.SessionFactory;
import org.mjmayor.baseproject.assembler.asignatura.AsignaturaFormAssembler;
import org.mjmayor.baseproject.assembler.asignatura.AsignaturaViewAssembler;
import org.mjmayor.baseproject.dao.AsignaturaDAO;
import org.mjmayor.baseproject.dao.impl.AsignaturaDAOImpl;
import org.mjmayor.baseproject.facade.AsignaturaFacade;
import org.mjmayor.baseproject.facade.impl.AsignaturaFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AsignaturaBeansConfig {

	@Autowired
	private SessionFactory sessionFactory;

	@Bean
	public AsignaturaFacade asignaturaFacade() {
		return new AsignaturaFacadeImpl(asignaturaDAO(), asignaturaViewAssembler());
	}

	@Bean
	public AsignaturaDAO asignaturaDAO() {
		return new AsignaturaDAOImpl(sessionFactory, asignaturaFormAssembler());
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
