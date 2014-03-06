package org.mjmayor.persistence.config;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.mjmayor.jpa.config.database.PersistenceConfig;
import org.mjmayor.jpa.service.Service;
import org.mjmayor.jpa.service.impl.ServiceImpl;
import org.mjmayor.model.dto.AsignaturaDTO;
import org.mjmayor.model.entity.Asignatura;
import org.mjmayor.persistence.assembler.asignatura.AsignaturaDTOAssembler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ PersistenceConfig.class })
public class AsignaturaPersistenceConfig {

	@PersistenceContext
	private EntityManager entityManager;

	@Bean
	public AsignaturaDTOAssembler asignaturaDTOAssembler() {
		return new AsignaturaDTOAssembler();
	}

	@Bean(name = "asignaturaService")
	public Service<Asignatura, AsignaturaDTO> service() {
		return new ServiceImpl<Asignatura, AsignaturaDTO>(entityManager, asignaturaDTOAssembler(), Asignatura.class);
	}
}
