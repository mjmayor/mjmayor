package org.mjmayor.baseproject.config;

import org.mjmayor.baseproject.assembler.asignatura.AsignaturaFormAssembler;
import org.mjmayor.baseproject.assembler.asignatura.AsignaturaViewAssembler;
import org.mjmayor.baseproject.facade.AsignaturaFacade;
import org.mjmayor.baseproject.facade.impl.AsignaturaFacadeImpl;
import org.mjmayor.jpa.service.Service;
import org.mjmayor.model.dto.AsignaturaDTO;
import org.mjmayor.model.entity.Asignatura;
import org.mjmayor.persistence.config.AsignaturaPersistenceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ AsignaturaPersistenceConfig.class })
public class AsignaturaBeanConfig {

	@Autowired
	@Qualifier(value = "asignaturaService")
	private Service<Asignatura, AsignaturaDTO> asignaturaService;

	@Bean(name = "asignaturaFacade")
	public AsignaturaFacade asignaturaFacade() {
		return new AsignaturaFacadeImpl(asignaturaService, asignaturaViewAssembler());
	}

	@Bean
	public AsignaturaViewAssembler asignaturaViewAssembler() {
		return new AsignaturaViewAssembler();
	}

	@Bean
	public AsignaturaFormAssembler asignaturaFormAssembler() {
		return new AsignaturaFormAssembler();
	}
}
