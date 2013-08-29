package org.mjmayor.persistence.config;

import javax.persistence.EntityManager;

import org.mjmayor.persistence.assembler.profesor.ProfesorDTOAssembler;
import org.mjmayor.persistence.dto.ProfesorDTO;
import org.mjmayor.persistence.entity.Profesor;
import org.mjmayor.persistence.service.Service;
import org.mjmayor.persistence.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfesorPersistenceConfig {

	@Autowired
	private EntityManager entityManager;

	public Service<Profesor, ProfesorDTO> service() {
		return new ServiceImpl<Profesor, ProfesorDTO>(entityManager, profesorDTOAssembler());
	}

	@Bean
	public ProfesorDTOAssembler profesorDTOAssembler() {
		return new ProfesorDTOAssembler();
	}
}
