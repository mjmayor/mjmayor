package org.mjmayor.jpa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.mjmayor.jpa.assembler.AlumnoFormAssembler;
import org.mjmayor.jpa.constants.AlumnoConstants;
import org.mjmayor.jpa.dao.AlumnoDAO;
import org.mjmayor.jpa.dto.AlumnoDTO;
import org.mjmayor.jpa.form.AlumnoForm;
import org.mjmayor.utils.list.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlumnoDAOImpl implements AlumnoDAO {

	private static final Logger logger = LoggerFactory.getLogger(AlumnoDAOImpl.class);

	private SessionFactory sessionFactory;

	private AlumnoFormAssembler alumnoFormAssembler;

	public AlumnoDAOImpl(SessionFactory sessionFactory, AlumnoFormAssembler alumnoFormAssembler) {
		this.sessionFactory = sessionFactory;
		this.alumnoFormAssembler = alumnoFormAssembler;
	}

	public void addAlumno(AlumnoForm alumnoForm) {
		logger.debug("AlumnoDAOImpl - addAlumno");
		AlumnoDTO alumnoDTO = alumnoFormAssembler.assemble(alumnoForm);
		sessionFactory.getCurrentSession().save(alumnoDTO);
	}

	public List<AlumnoDTO> getAlumnos() {
		logger.debug("AlumnoDAOImpl - getAlumnos");
		return ListUtils.castList(AlumnoDTO.class, sessionFactory.getCurrentSession().createQuery(AlumnoConstants.Database.Queries.FIND_ALL).list());
	}

	public AlumnoDTO getAlumno(AlumnoForm alumnoForm) {
		logger.debug("AlumnoDAOImpl - getAlumno");

		Query query = sessionFactory.getCurrentSession().createQuery(AlumnoConstants.Database.Queries.FIND_BY_DNI);
		query.setParameter(AlumnoConstants.Fields.DNI, alumnoForm.getDni());
		List<AlumnoDTO> alumnos = ListUtils.castList(AlumnoDTO.class, query.list());

		if (alumnos != null) {
			if (alumnos.size() > 0) {
				return alumnos.get(0);
			}

			else {
				return new AlumnoDTO();
			}
		} else {
			return new AlumnoDTO();
		}
	}

	public void removeAlumno(AlumnoForm alumnoForm) {
		logger.debug("AlumnoDAOImpl - removeAlumno");
		AlumnoDTO alumnoDTO = getAlumno(alumnoForm);
		if (alumnoDTO != null) {
			sessionFactory.getCurrentSession().delete(alumnoDTO);
		}
	}
}
