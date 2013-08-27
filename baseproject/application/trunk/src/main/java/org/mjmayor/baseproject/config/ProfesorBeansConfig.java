package org.mjmayor.baseproject.config;

import javax.persistence.EntityManager;

import org.mjmayor.baseproject.assembler.profesor.ProfesorDTOAssembler;
import org.mjmayor.baseproject.assembler.profesor.ProfesorFormAssembler;
import org.mjmayor.baseproject.assembler.profesor.ProfesorViewAssembler;
import org.mjmayor.baseproject.dto.ProfesorDTO;
import org.mjmayor.baseproject.entity.Profesor;
import org.mjmayor.baseproject.facade.ProfesorFacade;
import org.mjmayor.baseproject.facade.impl.ProfesorFacadeImpl;
import org.mjmayor.jpa.service.GenericService;
import org.mjmayor.jpa.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfesorBeansConfig {

	@Autowired
	private EntityManager entityManager;

	@Bean
	public ProfesorFacade profesorFacade() {
		// TODO configurar bien
		return new ProfesorFacadeImpl(service());
	}

	public GenericService<Profesor, ProfesorDTO> service() {
		return new GenericServiceImpl<Profesor, ProfesorDTO>(entityManager, profesorDTOAssembler());
	}

	@Bean
	public ProfesorViewAssembler profesorViewAssembler() {
		return new ProfesorViewAssembler();
	}

	@Bean
	public ProfesorFormAssembler profesorFormAssembler() {
		return new ProfesorFormAssembler();
	}

	@Bean
	public ProfesorDTOAssembler profesorDTOAssembler() {
		return new ProfesorDTOAssembler();
	}
}
