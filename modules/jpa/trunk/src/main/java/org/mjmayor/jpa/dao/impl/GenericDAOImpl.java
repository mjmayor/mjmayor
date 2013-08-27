package org.mjmayor.jpa.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolationException;

import org.hibernate.Criteria;
import org.mjmayor.jpa.dao.GenericDAO;
import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//TODO mjmayor Comprobar el manejo de excepciones
public class GenericDAOImpl<ENTITY> implements GenericDAO<ENTITY> {

	private static final Logger logger = LoggerFactory.getLogger(GenericDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Clase sobre la que se realizara la persistencia (clase del objeto sobre el que interactuar)
	 */
	private Class<ENTITY> persistentClass;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
		if (getClass().getSuperclass().equals((GenericDAOImpl.class))) {
			persistentClass = (Class<ENTITY>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		} else {
			persistentClass = (Class<ENTITY>) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[1];
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(ENTITY entity) throws ConstraintViolationException, JPAPersistenceException {
		logger.debug("DAOImpl - add");
		try {
			entityManager.persist(entity);
		} catch (Exception e) {
			throw new JPAPersistenceException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(ENTITY entity) throws JPAPersistenceException {
		// TODO mjmayor Por hacer
		logger.debug("DAOImpl - update");
		try {
			entityManager.merge(entity);
		} catch (Exception e) {
			throw new JPAPersistenceException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeByField(String field, Object value) throws JPAPersistenceException, FieldNotFoundException {
		// TODO mjmayor Por hacer
		logger.debug("DAOImpl - removeByField");
		List<ENTITY> listEntity = getByField(field, value);
		if (listEntity != null && listEntity.size() > 0) {
			for (ENTITY entity : listEntity) {
				try {
					entityManager.remove(entity);
				} catch (Exception e) {
					throw new JPAPersistenceException(e);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeLikeField(String field, String value) throws JPAPersistenceException, FieldNotFoundException {
		// TODO mjmayor Por hacer
		logger.debug("DAOImpl - removeLikeField");
		List<ENTITY> listEntity = getLikeField(field, value);
		if (listEntity != null && listEntity.size() > 0) {
			for (ENTITY entity : listEntity) {
				entityManager.remove(entity);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ENTITY> getAll() {
		logger.debug("DAOImpl - getAll");
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ENTITY> countCriteria = builder.createQuery(persistentClass);
		countCriteria.from(persistentClass);
		return entityManager.createQuery(countCriteria).getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long countAll() {
		logger.debug("DAOImpl - countAll");
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countCriteria = builder.createQuery(Long.class);
		countCriteria.from(persistentClass);
		Root<?> entityRoot = countCriteria.getRoots().iterator().next();
		countCriteria.select(builder.count(entityRoot));
		return entityManager.createQuery(countCriteria).getSingleResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ENTITY> getByField(String field, Object value) throws FieldNotFoundException {
		// TODO mjmayor Por hacer
		logger.debug("DAOImpl - getByField");
		// String a = "from " + persistentClass.getSimpleName() + " where %s = :value";
		// String queryString = String.format(a, field);
		// Query query = session.createQuery(queryString);
		// query.setParameter("value", value);
		// return ListUtils.castList(persistentClass, query.list());
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ENTITY> getLikeField(String field, String value) throws FieldNotFoundException {
		// TODO mjmayor Por hacer
		logger.debug("DAOImpl - getLikeField");
		// Criteria criteria = session.createCriteria(persistentClass);
		// criteria.add(Restrictions.like(field, value, MatchMode.ANYWHERE));
		// List<entity> listentity = ListUtils.castList(persistentClass, criteria.list());
		// session.close();
		// return listentity;
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ENTITY> getByCriteria(Criteria criteria) throws JPAPersistenceException {
		// TODO mjmayor Por hacer
		logger.debug("DAOImpl - getLikeAllFields");
		// Criteria criteria = session.createCriteria(persistentClass);
		// addRestrictions(criteria, form);
		// List<entity> listentity = ListUtils.castList(persistentClass, criteria.list());
		// session.close();
		// return listentity;
		return null;
	}
}
