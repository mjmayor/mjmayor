package org.mjmayor.baseproject.dao.impl;

import java.util.List;

import org.h2.util.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.mjmayor.baseproject.assembler.asignatura.AsignaturaFormAssembler;
import org.mjmayor.baseproject.constants.AsignaturaConstants;
import org.mjmayor.baseproject.dao.AsignaturaDAO;
import org.mjmayor.baseproject.dto.AsignaturaDTO;
import org.mjmayor.baseproject.form.AsignaturaForm;
import org.mjmayor.utils.list.ListUtils;
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
		String queryString = String.format(AsignaturaConstants.Database.Queries.FIND_BY_FIELD, field);
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setParameter(AsignaturaConstants.Database.Queries.VALUE, value);
		return ListUtils.castList(AsignaturaDTO.class, query.list());
	}

	/**
	 * {@inheritDoc}
	 */
	// TODO mjmayor Hacer un AbstractDAO que implemente una interfaz DAO, y que defina los metodos: insert, delete, update, getAll, getByField, getLikeField (para el paso 4)
	@Override
	public List<AsignaturaDTO> getAsignaturasLikeField(String field, String value) {
		logger.debug("AsignaturaDAOImpl - getAsignaturasLikeField");

		Session session = null;
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(AsignaturaDTO.class);
		criteria.add(Restrictions.like(field, value, MatchMode.ANYWHERE));
		List<AsignaturaDTO> listaDTO = ListUtils.castList(AsignaturaDTO.class, criteria.list());
		session.close();
		return listaDTO;
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
			criteria.add(Restrictions.like(AsignaturaConstants.Fields.CODIGO, codigo, MatchMode.ANYWHERE));
		}

		String nombre = asignaturaForm.getNombre();
		if (!StringUtils.isNullOrEmpty(nombre)) {
			criteria.add(Restrictions.like(AsignaturaConstants.Fields.NOMBRE, nombre, MatchMode.ANYWHERE));
		}

		int curso = asignaturaForm.getCurso();
		if (curso > 0) {
			criteria.add(Restrictions.eq(AsignaturaConstants.Fields.CURSO, curso));
		}

		Float creditos = asignaturaForm.getCreditos();
		if (creditos!=null && creditos > 0.0f) {
			criteria.add(Restrictions.eq(AsignaturaConstants.Fields.CREDITOS, creditos));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeAsignatura(AsignaturaForm asignaturaForm) {
		logger.debug("AsignaturaDAOImpl - removeAsignatura");
		List<AsignaturaDTO> asignaturas = getAsignaturasByField(AsignaturaConstants.Fields.CODIGO, asignaturaForm.getCodigo());
		for (AsignaturaDTO asignatura : asignaturas) {
			sessionFactory.getCurrentSession().delete(asignatura);
		}
	}
}
