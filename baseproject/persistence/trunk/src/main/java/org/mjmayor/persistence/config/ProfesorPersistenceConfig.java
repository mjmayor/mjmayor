package org.mjmayor.persistence.config;

import javax.persistence.EntityManager;

import org.mjmayor.model.dto.ProfesorDTO;
import org.mjmayor.model.entity.Profesor;
import org.mjmayor.persistence.assembler.profesor.ProfesorDTOAssembler;
import org.mjmayor.persistence.service.ProfesorService;
import org.mjmayor.persistence.service.impl.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfesorPersistenceConfig {

	@Autowired
	private EntityManager entityManager;

	public ProfesorService<Profesor, ProfesorDTO> service() {
		return new ProfesorServiceImpl<Profesor, ProfesorDTO>(entityManager, profesorDTOAssembler());
	}

	@Bean
	public ProfesorDTOAssembler profesorDTOAssembler() {
		return new ProfesorDTOAssembler();
	}
}
