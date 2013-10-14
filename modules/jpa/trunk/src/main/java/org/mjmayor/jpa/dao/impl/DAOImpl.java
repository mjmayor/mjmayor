package org.mjmayor.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.ConstraintViolationException;

import org.mjmayor.jpa.dao.DAO;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.mjmayor.jpa.support.Criteria;
import org.mjmayor.jpa.support.PageRequest;
import org.mjmayor.jpa.support.PersistenceUtils;
import org.mjmayor.utils.list.ListUtils;
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

	public DAOImpl(EntityManager entityManager, Class<ENTITY> persistentClass) {
		this.entityManager = entityManager;
		this.persistentClass = persistentClass;
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
	public void remove(CriteriaQuery<ENTITY> criteriaQuery) throws JPAPersistenceException {
		// TODO mjmayor Auto-generated method stub
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ENTITY get(Long id) {
		return entityManager.find(persistentClass, id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ENTITY> get(CriteriaQuery<ENTITY> criteriaQuery, Criteria criteria) throws JPAPersistenceException {
		Query query = entityManager.createQuery(criteriaQuery);
		setCriteriaParams(criteria, query);
		return ListUtils.castList(persistentClass, query.getResultList());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long count(CriteriaQuery<Long> criteriaQuery) {
		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}

	private void setCriteriaParams(Criteria criteria, Query query) {
		if (criteria != null && criteria.getPageRequest() != null) {
			PageRequest pageRequest = criteria.getPageRequest();
			query.setFirstResult(PersistenceUtils.getFirstResult(pageRequest));
			query.setMaxResults(pageRequest.getSize());
		}
	}
}
