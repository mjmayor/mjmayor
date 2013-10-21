package org.mjmayor.baseproject.config;

import org.mjmayor.baseproject.assembler.profesor.ProfesorFormAssembler;
import org.mjmayor.baseproject.assembler.profesor.ProfesorViewAssembler;
import org.mjmayor.baseproject.facade.ProfesorFacade;
import org.mjmayor.baseproject.facade.impl.ProfesorFacadeImpl;
import org.mjmayor.jpa.service.Service;
import org.mjmayor.model.dto.ProfesorDTO;
import org.mjmayor.model.entity.Profesor;
import org.mjmayor.persistence.config.ProfesorPersistenceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ ProfesorPersistenceConfig.class })
public class ProfesorBeanConfig {

	@Autowired
	private Service<Profesor, ProfesorDTO> service;

	@Bean
	public ProfesorFacade profesorFacade() {
		return new ProfesorFacadeImpl(service, profesorViewAssembler());
	}

	@Bean
	public ProfesorViewAssembler profesorViewAssembler() {
		return new ProfesorViewAssembler();
	}

	@Bean
	public ProfesorFormAssembler profesorFormAssembler() {
		return new ProfesorFormAssembler();
	}
}
