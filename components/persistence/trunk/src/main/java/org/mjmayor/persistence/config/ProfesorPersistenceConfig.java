package org.mjmayor.persistence.config;

import javax.persistence.EntityManager;

import org.mjmayor.jpa.dao.DAO;
import org.mjmayor.jpa.dao.impl.DAOImpl;
import org.mjmayor.jpa.service.Service;
import org.mjmayor.jpa.service.impl.ServiceImpl;
import org.mjmayor.model.dto.ProfesorDTO;
import org.mjmayor.model.entity.Profesor;
import org.mjmayor.persistence.assembler.profesor.ProfesorDTOAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfesorPersistenceConfig {

	@Autowired
	@Qualifier("entityManager")
	private EntityManager entityManager;

	@Bean
	public ProfesorDTOAssembler profesorDTOAssembler() {
		return new ProfesorDTOAssembler();
	}

	@Bean
	public Service<Profesor, ProfesorDTO> service() {
		DAO<Profesor> dao = new DAOImpl<Profesor>(entityManager, Profesor.class);
		return new ServiceImpl<Profesor, ProfesorDTO>(dao, profesorDTOAssembler());
	}
}
