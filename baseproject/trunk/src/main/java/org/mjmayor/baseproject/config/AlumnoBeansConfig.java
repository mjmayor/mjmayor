package org.mjmayor.baseproject.config;

import org.hibernate.SessionFactory;
import org.mjmayor.baseproject.assembler.alumno.AlumnoFormAssembler;
import org.mjmayor.baseproject.assembler.alumno.AlumnoViewAssembler;
import org.mjmayor.baseproject.dao.AlumnoDAO;
import org.mjmayor.baseproject.dao.impl.AlumnoDAOImpl;
import org.mjmayor.baseproject.facade.AlumnoFacade;
import org.mjmayor.baseproject.facade.impl.AlumnoFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AlumnoBeansConfig {

	@Autowired
	private SessionFactory sessionFactory;

	@Bean
	public AlumnoFacade alumnoFacade() {
		return new AlumnoFacadeImpl(alumnoDAO(), alumnoViewAssembler());
	}

	@Bean
	public AlumnoDAO alumnoDAO() {
		return new AlumnoDAOImpl(sessionFactory, alumnoFormAssembler());
	}

	@Bean
	public AlumnoViewAssembler alumnoViewAssembler() {
		return new AlumnoViewAssembler();
	}

	@Bean
	public AlumnoFormAssembler alumnoFormAssembler() {
		return new AlumnoFormAssembler();
	}
}
