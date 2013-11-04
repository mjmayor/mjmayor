package org.mjmayor.persistence.config;

import org.mjmayor.jpa.config.database.PersistenceConfig;
import org.mjmayor.jpa.service.Service;
import org.mjmayor.jpa.service.impl.ServiceImpl;
import org.mjmayor.model.dto.AlumnoDTO;
import org.mjmayor.model.entity.Alumno;
import org.mjmayor.persistence.assembler.alumno.AlumnoDTOAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@Import({ PersistenceConfig.class })
public class AlumnoPersistenceConfig {

	@Autowired
	private LocalContainerEntityManagerFactoryBean entityManagerFactory;

	@Bean
	public AlumnoDTOAssembler alumnoDTOAssembler() {
		return new AlumnoDTOAssembler();
	}

	@Bean(name = "alumnoService")
	public Service<Alumno, AlumnoDTO> service() {
		return new ServiceImpl<Alumno, AlumnoDTO>(entityManagerFactory, alumnoDTOAssembler(), Alumno.class);
	}
}
