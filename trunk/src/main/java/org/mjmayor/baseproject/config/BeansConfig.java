package org.mjmayor.baseproject.config;

import org.hibernate.SessionFactory;
import org.mjmayor.baseproject.assembler.AlumnoAssembler;
import org.mjmayor.baseproject.dao.AlumnoDAO;
import org.mjmayor.baseproject.dao.impl.AlumnoDAOImpl;
import org.mjmayor.baseproject.facade.AlumnoFacade;
import org.mjmayor.baseproject.facade.impl.AlumnoFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

	@Autowired
	//private LocalSessionFactoryBean sessionFactory;
	private SessionFactory sessionFactory;
	
	@Bean
	public AlumnoFacade alumnoFacade(){
		return new AlumnoFacadeImpl(alumnoDAO(), alumnoAssembler());
	}
	
	@Bean
	public AlumnoDAO alumnoDAO(){
		return new AlumnoDAOImpl(sessionFactory);
	}
	
	@Bean
	public AlumnoAssembler alumnoAssembler(){
		return new AlumnoAssembler();
	}
}
