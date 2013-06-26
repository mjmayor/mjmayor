package org.mjmayor.baseproject.dao.impl;

import java.util.List;

import org.h2.util.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.mjmayor.baseproject.assembler.asignatura.AsignaturaFormAssembler;
import org.mjmayor.baseproject.constants.AsignaturaConstants;
import org.mjmayor.baseproject.dao.AsignaturaDAO;
import org.mjmayor.baseproject.dto.AsignaturaDTO;
import org.mjmayor.baseproject.form.AsignaturaForm;
import org.mjmayor.baseproject.utils.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsignaturaDAOImpl implements AsignaturaDAO {

	private static final Logger logger = LoggerFactory.getLogger(AsignaturaDAOImpl.class);

	private SessionFactory sessionFactory;

	private AsignaturaFormAssembler asignaturaFormAssembler;

	public AsignaturaDAOImpl(SessionFactory sessionFactory, AsignaturaFormAssembler asignaturaFormAssembler) {
		this.sessionFactory = sessionFactory;
		this.asignaturaFormAssembler = asignaturaFormAssembler;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addAsignatura(AsignaturaForm asignaturaForm) {
		logger.debug("AsignaturaDAOImpl - addAsignatura");
		AsignaturaDTO asignaturaDTO = asignaturaFormAssembler.assemble(asignaturaForm);
		sessionFactory.getCurrentSession().save(asignaturaDTO);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<AsignaturaDTO> getAsignaturas() {
		logger.debug("AsignaturaDAOImpl - getAsignaturas");
		return ListUtils.castList(AsignaturaDTO.class, sessionFactory.getCurrentSession().createQuery(AsignaturaConstants.Database.Queries.FIND_ALL).list());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<AsignaturaDTO> getAsignaturasByField(String field, Object value) {
		logger.debug("AsignaturaDAOImpl - getAsignaturasByField");
		Query query = sessionFactory.getCurrentSession().createQuery(AsignaturaConstants.Database.Queries.FIND_BY_FIELD);
		query.setParameter(field, value);
		return ListUtils.castList(AsignaturaDTO.class, query.list());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<AsignaturaDTO> getAsignaturasLikeField(String field, Object value) {
		logger.debug("AsignaturaDAOImpl - getAsignaturasLikeField");
		Query query = sessionFactory.getCurrentSession().createQuery(AsignaturaConstants.Database.Queries.FIND_LIKE_FIELD);
		query.setParameter(field, value);
		return ListUtils.castList(AsignaturaDTO.class, query.list());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<AsignaturaDTO> getAsignaturas(AsignaturaForm asignaturaForm) {
		logger.debug("AsignaturaDAOImpl - getAsignaturas");

		Session session = null;
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(AsignaturaDTO.class);
		addRestrictions(criteria, asignaturaForm);
		List<AsignaturaDTO> listaDTO = ListUtils.castList(AsignaturaDTO.class, criteria.list());
		session.close();
		return listaDTO;
	}

	private void addRestrictions(Criteria criteria, AsignaturaForm asignaturaForm) {

		String codigo = asignaturaForm.getCodigo();
		if (!StringUtils.isNullOrEmpty(codigo)) {
			criteria.add(Restrictions.like(AsignaturaConstants.Fields.CODIGO, codigo));
		}

		String nombre = asignaturaForm.getNombre();
		if (!StringUtils.isNullOrEmpty(nombre)) {
			criteria.add(Restrictions.like(AsignaturaConstants.Fields.NOMBRE, nombre));
		}

		int curso = asignaturaForm.getCurso();
		if (curso > 0) {
			criteria.add(Restrictions.like(AsignaturaConstants.Fields.CURSO, curso));
		}

		float creditos = asignaturaForm.getCreditos();
		if (creditos > 0.0f) {
			criteria.add(Restrictions.like(AsignaturaConstants.Fields.CREDITOS, creditos));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeAsignatura(AsignaturaForm asignaturaForm) {
		logger.debug("AsignaturaDAOImpl - removeAsignatura");
		List<AsignaturaDTO> asignaturas = getAsignaturasByField(AsignaturaConstants.Fields.CODIGO, asignaturaForm.getCodigo());
		if (asignaturas.size() > 0) {
			sessionFactory.getCurrentSession().delete(asignaturas);
		}
	}
}
