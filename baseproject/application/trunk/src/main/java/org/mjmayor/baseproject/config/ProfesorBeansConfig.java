package org.mjmayor.baseproject.config;

import javax.persistence.EntityManager;

import org.mjmayor.baseproject.assembler.profesor.ProfesorDTOAssembler;
import org.mjmayor.baseproject.assembler.profesor.ProfesorFormAssembler;
import org.mjmayor.baseproject.assembler.profesor.ProfesorViewAssembler;
import org.mjmayor.baseproject.dto.ProfesorDTO;
import org.mjmayor.baseproject.entity.Profesor;
import org.mjmayor.baseproject.facade.ProfesorFacade;
import org.mjmayor.baseproject.facade.impl.ProfesorFacadeImpl;
import org.mjmayor.jpa.service.Service;
import org.mjmayor.jpa.service.impl.ServiceImpl;
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

	public Service<ProfesorDTO, Profesor> service() {
		return new ServiceImpl<ProfesorDTO, Profesor>(entityManager, profesorDTOAssembler());
	}

	@Bean
	public ProfesorViewAssembler profesorViewAssembler() {
		return new ProfesorViewAssembler();
	}

	@Bean
	public ProfesorFormAssembler profesorFormAssembler() {
		return new ProfesorFormAssembler();
	}

	public ProfesorDTOAssembler profesorDTOAssembler() {
		return new ProfesorDTOAssembler();
	}
}
