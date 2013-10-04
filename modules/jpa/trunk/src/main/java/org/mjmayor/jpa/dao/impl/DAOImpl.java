package org.mjmayor.jpa.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.ConstraintViolationException;

import org.mjmayor.jpa.dao.DAO;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.mjmayor.jpa.support.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAOImpl<ENTITY> implements DAO<ENTITY> {

	private static final Logger logger = LoggerFactory.getLogger(DAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Clase sobre la que se realizara la persistencia (clase del objeto sobre el que interactuar)
	 */
	private Class<ENTITY> persistentClass;

	/**
	 * CriteriaBuilder para construir consultas JPA
	 */
	private CriteriaBuilder criteriaBuilder;

	@SuppressWarnings("unchecked")
	public DAOImpl(EntityManagerFactory entityManagerFactory) {
		this.entityManager = entityManagerFactory.createEntityManager();
		this.criteriaBuilder = entityManager.getCriteriaBuilder();

		if (getClass().getSuperclass().equals((DAOImpl.class))) {
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

	@Override
	public void remove(CriteriaQuery<ENTITY> criteriaQuery) throws JPAPersistenceException {
		// TODO mjmayor Auto-generated method stub
	}

	@Override
	public Long countAll() {
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(persistentClass)));
		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}

	@Override
	public ENTITY get(Long id) {
		return entityManager.find(persistentClass, id);
	}

	@Override
	public List<ENTITY> get(Criteria criteria) throws JPAPersistenceException {
		// TODO mjmayor Auto-generated method stub
		return null;
	}

	@Override
	public List<ENTITY> get(CriteriaQuery<ENTITY> criteriaQuery) throws JPAPersistenceException {
		// TODO mjmayor Auto-generated method stub
		return null;
	}
}
