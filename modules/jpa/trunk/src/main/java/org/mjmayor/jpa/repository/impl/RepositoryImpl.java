package org.mjmayor.jpa.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolationException;

import org.mjmayor.jpa.constants.RepositoryConstants;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.mjmayor.jpa.repository.Repository;
import org.mjmayor.jpa.support.Criteria;
import org.mjmayor.jpa.support.PageRequest;
import org.mjmayor.jpa.support.PageResult;
import org.mjmayor.utils.list.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RepositoryImpl<ENTITY extends Serializable> implements Repository<ENTITY> {

	private static final Logger logger = LoggerFactory.getLogger(RepositoryImpl.class);

	private EntityManager entityManager;

	private CriteriaBuilder criteriaBuilder;

	/**
	 * @return the criteriaBuilder
	 */
	@Override
	public CriteriaBuilder getCriteriaBuilder() {
		return criteriaBuilder;
	}

	/**
	 * Clase sobre la que se realizara la persistencia (clase del objeto sobre el que interactuar)
	 */
	private Class<ENTITY> persistentClass;

	public RepositoryImpl(EntityManager entityManager, Class<ENTITY> persistentClass) {
		this.entityManager = entityManager;
		this.persistentClass = persistentClass;
		this.criteriaBuilder = entityManager.getCriteriaBuilder();
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
	public void delete(Long id) {
		logger.debug("DAOImpl - remove");
		try {
			entityManager.remove(get(id));
		} catch (Exception e) {
			throw new JPAPersistenceException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(List<ENTITY> entities) throws JPAPersistenceException {
		logger.debug("DAOImpl - remove");
		try {
			for (ENTITY entity : entities) {
				entityManager.remove(entity);
			}
		} catch (Exception e) {
			throw new JPAPersistenceException(e);
		}
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
	public PageResult<ENTITY> get(CriteriaQuery<ENTITY> criteriaQuery, Criteria criteria) throws JPAPersistenceException {
		Query query = entityManager.createQuery(criteriaQuery);
		setCriteriaParams(query, criteria);
		List<ENTITY> result = ListUtils.castList(query.getResultList(), persistentClass);
		Long total = count(createCountQuery(criteriaQuery), null);
		return new PageResult<ENTITY>(result, total, criteria);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PageResult<ENTITY> get(String hql, Criteria criteria) throws JPAPersistenceException {
		Query query = entityManager.createQuery(hql);
		List<ENTITY> result = ListUtils.castList(query.getResultList(), persistentClass);
		Long total = count(hql, null);
		return new PageResult<ENTITY>(result, total, criteria);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long count(CriteriaQuery<Long> criteriaQuery, Criteria criteria) {
		Query query = entityManager.createQuery(criteriaQuery);
		setCriteriaParams(query, criteria);
		return (Long) query.getSingleResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long count(String hql, Criteria criteria) {
		Query query = entityManager.createQuery(String.format(RepositoryConstants.COUNT_QUERY, hql));
		setCriteriaParams(query, criteria);
		return (Long) query.getSingleResult();
	}

	private CriteriaQuery<Long> createCountQuery(CriteriaQuery<ENTITY> criteriaQuery) {
		CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
		Root<?> root = criteriaQuery.getRoots().iterator().next();
		countQuery.select(criteriaBuilder.countDistinct(root));
		countQuery.from(persistentClass);

		Predicate groupRestriction = criteriaQuery.getGroupRestriction();
		if (groupRestriction != null) {
			countQuery.having(groupRestriction);
		}

		Predicate fromRestriction = criteriaQuery.getRestriction();
		if (fromRestriction != null) {
			countQuery.where(fromRestriction);
		}
		countQuery.groupBy(criteriaQuery.getGroupList());
		return countQuery;
	}

	private void setCriteriaParams(Query query, Criteria criteria) {
		if (criteria != null && criteria.getPageRequest() != null) {
			PageRequest pageRequest = criteria.getPageRequest();
			query.setFirstResult(pageRequest.getFirstResult());
			query.setMaxResults(pageRequest.getSize());
		}
	}
}
