package org.mjmayor.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
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

	/**
	 * CriteriaBuilder para construir consultas JPA
	 */
	private CriteriaBuilder criteriaBuilder;

	public DAOImpl(EntityManager entityManager, Class<ENTITY> persistentClass) {
		this.entityManager = entityManager;
		this.criteriaBuilder = entityManager.getCriteriaBuilder();
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
		CriteriaQuery<ENTITY> criteriaQuery = criteriaBuilder.createQuery(persistentClass);
		criteriaQuery.select(criteriaQuery.from(persistentClass));
		Query query = entityManager.createQuery(criteriaQuery);

		PageRequest pageRequest = criteria.getPageRequest();
		query.setFirstResult(PersistenceUtils.getFirstResult(pageRequest));
		query.setMaxResults(pageRequest.getSize());
		return ListUtils.castList(persistentClass, query.getResultList());
	}

	@Override
	public List<ENTITY> get(CriteriaQuery<ENTITY> criteriaQuery, Criteria criteria) throws JPAPersistenceException {
		// TODO mjmayor Auto-generated method stub
		// CriteriaBuilder qb = em.getCriteriaBuilder();
		// CriteriaQuery<Submission> cq = qb.createQuery(Submission.class);
		//
		// Root<Submission> root = cq.from(Submission.class);
		// cq.where( qb.or(
		// qb.equal(root.get("code"), qb.parameter(String.class, "code")),
		// qb.equal(root.get("id"), qb.parameter(Integer.class, "id"))
		// ));
		// Query query = em.createQuery(cq);
		return null;
	}
}
