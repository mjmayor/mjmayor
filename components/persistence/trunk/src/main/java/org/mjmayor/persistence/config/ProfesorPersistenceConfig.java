package org.mjmayor.persistence.config;

import org.mjmayor.jpa.service.Service;
import org.mjmayor.jpa.service.impl.ServiceImpl;
import org.mjmayor.model.dto.ProfesorDTO;
import org.mjmayor.model.entity.Profesor;
import org.mjmayor.persistence.assembler.profesor.ProfesorDTOAssembler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfesorPersistenceConfig {

	@Bean
	public ProfesorDTOAssembler profesorDTOAssembler() {
		return new ProfesorDTOAssembler();
	}

	@Bean
	public Service<Profesor, ProfesorDTO> service() {
		return new ServiceImpl<Profesor, ProfesorDTO>(profesorDTOAssembler(), Profesor.class);
	}
}
