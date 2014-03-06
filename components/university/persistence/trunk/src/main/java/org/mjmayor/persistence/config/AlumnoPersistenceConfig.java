package org.mjmayor.persistence.config;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.mjmayor.jpa.config.database.PersistenceConfig;
import org.mjmayor.jpa.service.Service;
import org.mjmayor.jpa.service.impl.ServiceImpl;
import org.mjmayor.model.dto.AlumnoDTO;
import org.mjmayor.model.entity.Alumno;
import org.mjmayor.persistence.assembler.alumno.AlumnoDTOAssembler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ PersistenceConfig.class })
public class AlumnoPersistenceConfig {

	@PersistenceContext
	private EntityManager entityManager;

	@Bean
	public AlumnoDTOAssembler alumnoDTOAssembler() {
		return new AlumnoDTOAssembler();
	}

	@Bean(name = "alumnoService")
	public Service<Alumno, AlumnoDTO> service() {
		return new ServiceImpl<Alumno, AlumnoDTO>(entityManager, alumnoDTOAssembler(), Alumno.class);
	}
}
