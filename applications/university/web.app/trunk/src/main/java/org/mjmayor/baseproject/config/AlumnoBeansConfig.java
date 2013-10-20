package org.mjmayor.baseproject.config;

import org.hibernate.SessionFactory;
import org.mjmayor.baseproject.assembler.alumno.AlumnoViewAssembler;
import org.mjmayor.baseproject.facade.AlumnoFacade;
import org.mjmayor.baseproject.facade.impl.AlumnoFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

//@Configuration
public class AlumnoBeansConfig {

	@Autowired
	private SessionFactory sessionFactory;

	@Bean
	public AlumnoFacade alumnoFacade() {
		return new AlumnoFacadeImpl(null);
	}

	@Bean
	public AlumnoViewAssembler alumnoViewAssembler() {
		return new AlumnoViewAssembler();
	}
}
