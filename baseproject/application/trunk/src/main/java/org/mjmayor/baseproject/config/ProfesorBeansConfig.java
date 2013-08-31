package org.mjmayor.baseproject.config;

import org.mjmayor.baseproject.assembler.profesor.ProfesorFormAssembler;
import org.mjmayor.baseproject.assembler.profesor.ProfesorViewAssembler;
import org.mjmayor.baseproject.facade.ProfesorFacade;
import org.mjmayor.baseproject.facade.impl.ProfesorFacadeImpl;
import org.mjmayor.model.dto.ProfesorDTO;
import org.mjmayor.model.entity.Profesor;
import org.mjmayor.persistence.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfesorBeansConfig {

//	@Autowired
	private ProfesorService<Profesor, ProfesorDTO> service;

	@Bean
	public ProfesorFacade profesorFacade() {
		// TODO configurar bien
		return new ProfesorFacadeImpl(null);
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
