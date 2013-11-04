package org.mjmayor.baseproject.config;

import org.mjmayor.baseproject.assembler.alumno.AlumnoFormAssembler;
import org.mjmayor.baseproject.assembler.alumno.AlumnoViewAssembler;
import org.mjmayor.baseproject.facade.AlumnoFacade;
import org.mjmayor.baseproject.facade.impl.AlumnoFacadeImpl;
import org.mjmayor.jpa.service.Service;
import org.mjmayor.model.dto.AlumnoDTO;
import org.mjmayor.model.entity.Alumno;
import org.mjmayor.persistence.config.AlumnoPersistenceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ AlumnoPersistenceConfig.class })
public class AlumnoBeanConfig {

	@Autowired
	@Qualifier(value = "alumnoService")
	private Service<Alumno, AlumnoDTO> alumnoService;

	@Bean(name = "alumnoFacade")
	public AlumnoFacade alumnoFacade() {
		return new AlumnoFacadeImpl(alumnoService, alumnoViewAssembler());
	}

	@Bean
	public AlumnoViewAssembler alumnoViewAssembler() {
		return new AlumnoViewAssembler();
	}

	@Bean
	public AlumnoFormAssembler alumnoFormAssembler() {
		return new AlumnoFormAssembler();
	}
}
