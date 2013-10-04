package org.mjmayor.persistence.config;

import org.mjmayor.jpa.dao.DAO;
import org.mjmayor.jpa.dao.impl.DAOImpl;
import org.mjmayor.model.dto.ProfesorDTO;
import org.mjmayor.model.entity.Profesor;
import org.mjmayor.persistence.assembler.profesor.ProfesorDTOAssembler;
import org.mjmayor.persistence.service.ProfesorService;
import org.mjmayor.persistence.service.impl.ProfesorServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfesorPersistenceConfig {

	@Bean
	public ProfesorService<Profesor, ProfesorDTO> service() {
		return new ProfesorServiceImpl<Profesor, ProfesorDTO>(dao(), profesorDTOAssembler());
	}

	@Bean
	public ProfesorDTOAssembler profesorDTOAssembler() {
		return new ProfesorDTOAssembler();
	}

	@Bean
	public DAO<Profesor> dao() {
		return new DAOImpl<Profesor>(null);
	}
}
