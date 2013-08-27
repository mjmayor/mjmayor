package org.mjmayor.baseproject.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.mjmayor.baseproject.assembler.profesor.ProfesorFormAssembler;
import org.mjmayor.baseproject.constants.ProfesorConstants;
import org.mjmayor.baseproject.dao.ProfesorDAO;
import org.mjmayor.baseproject.dto.ProfesorDTO;
import org.mjmayor.baseproject.form.ProfesorForm;
import org.mjmayor.baseproject.utils.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfesorDAOImpl implements ProfesorDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProfesorDAOImpl.class);

	private SessionFactory sessionFactory;

	private ProfesorFormAssembler profesorFormAssembler;

	public ProfesorDAOImpl(SessionFactory sessionFactory, ProfesorFormAssembler profesorFormAssembler) {
		this.sessionFactory = sessionFactory;
		this.profesorFormAssembler = profesorFormAssembler;
	}

	@Override
	public void addProfesor(ProfesorForm profesorForm) {
		logger.debug("ProfesorDAOImpl - addProfesor");
		ProfesorDTO profesorDTO = profesorFormAssembler.assemble(profesorForm);
		sessionFactory.getCurrentSession().save(profesorDTO);
	}

	@Override
	public List<ProfesorDTO> getProfesores() {
		logger.debug("ProfesorDAOImpl - getProfesores");
		return ListUtils.castList(ProfesorDTO.class, sessionFactory.getCurrentSession().createQuery(ProfesorConstants.Database.Queries.FIND_ALL).list());
	}

	@Override
	public ProfesorDTO getProfesor(ProfesorForm profesorForm) {
		logger.debug("ProfesorDAOImpl - getProfesor");

		Query query = sessionFactory.getCurrentSession().createQuery(ProfesorConstants.Database.Queries.FIND_BY_DNI);
		query.setParameter(ProfesorConstants.Fields.DNI, profesorForm.getDni());
		List<ProfesorDTO> profesores = ListUtils.castList(ProfesorDTO.class, query.list());

		if (profesores != null) {
			if (profesores.size() > 0) {
				return profesores.get(0);
			}

			else {
				return new ProfesorDTO();
			}
		} else {
			return new ProfesorDTO();
		}
	}

	@Override
	public void removeProfesor(ProfesorForm profesorForm) {
		logger.debug("ProfesorDAOImpl - removeProfesor");
		ProfesorDTO profesorDTO = getProfesor(profesorForm);
		if (profesorDTO != null) {
			sessionFactory.getCurrentSession().delete(profesorDTO);
		}
	}
}
