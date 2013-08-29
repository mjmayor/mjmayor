package org.mjmayor.baseproject.config;

import org.mjmayor.baseproject.assembler.profesor.ProfesorFormAssembler;
import org.mjmayor.baseproject.assembler.profesor.ProfesorViewAssembler;
import org.mjmayor.baseproject.facade.ProfesorFacade;
import org.mjmayor.baseproject.facade.impl.ProfesorFacadeImpl;
import org.mjmayor.persistence.dto.ProfesorDTO;
import org.mjmayor.persistence.entity.Profesor;
import org.mjmayor.persistence.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfesorBeansConfig {

	@Autowired
	private Service<Profesor, ProfesorDTO> service;

	@Bean
	public ProfesorFacade profesorFacade() {
		// TODO configurar bien
		return new ProfesorFacadeImpl(service);
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
