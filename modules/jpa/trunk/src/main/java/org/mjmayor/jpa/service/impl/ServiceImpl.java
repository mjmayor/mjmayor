package org.mjmayor.jpa.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolationException;

import org.mjmayor.jpa.assembler.BidirectionalAssembler;
import org.mjmayor.jpa.dao.DAO;
import org.mjmayor.jpa.dao.impl.DAOImpl;
import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.mjmayor.jpa.service.Service;
import org.mjmayor.jpa.support.Criteria;
import org.mjmayor.jpa.support.Field;
import org.mjmayor.jpa.support.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

public class ServiceImpl<ENTITY, DTO> implements Service<ENTITY, DTO> {

	private static final Logger logger = LoggerFactory.getLogger(DAOImpl.class);

	/**
	 * DAO que se encargara de las operaciones de persistencia
	 */
	private DAO<ENTITY> dao;

	/**
	 * CriteriaBuilder para construir consultas JPA
	 */
	private CriteriaBuilder criteriaBuilder;

	/**
	 * Clase sobre la que se realizara la persistencia (clase del objeto sobre el que interactuar)
	 */
	private Class<ENTITY> persistentClass;

	private BidirectionalAssembler<ENTITY, DTO> assembler;

	public ServiceImpl(EntityManager entityManager, BidirectionalAssembler<ENTITY, DTO> assembler, Class<ENTITY> persistentClass) {
		this.dao = new DAOImpl<ENTITY>(entityManager, persistentClass);
		this.criteriaBuilder = dao.getCriteriaBuilder();
		this.assembler = assembler;
		this.persistentClass = persistentClass;
	}

	/**
	 * @return the criteriaBuilder
	 */
	public CriteriaBuilder getCriteriaBuilder() {
		return criteriaBuilder;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(value = "transactionManager")
	public void add(DTO dto) throws ConstraintViolationException, JPAPersistenceException {
		ENTITY entity = assembler.reverseAssemble(dto);
		dao.add(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void update(DTO dto) throws JPAPersistenceException {
		ENTITY entity = assembler.reverseAssemble(dto);
		dao.update(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void remove(Long id) {
		dao.remove(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void remove(Field field) throws JPAPersistenceException, FieldNotFoundException {
		CriteriaQuery<ENTITY> criteriaQuery = createGetQuery(field);
		List<ENTITY> entities = dao.get(criteriaQuery, null).getItems();
		dao.remove(entities);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void removeLike(Field field) throws JPAPersistenceException, FieldNotFoundException {
		CriteriaQuery<ENTITY> criteriaQuery = createGetLikeQuery(field);
		List<ENTITY> entities = dao.get(criteriaQuery, null).getItems();
		dao.remove(entities);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public DTO get(Long id) {
		ENTITY entity = dao.get(id);
		return assembler.assemble(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public PageResult<DTO> get(CriteriaQuery<ENTITY> criteriaQuery, Criteria criteria) {
		PageResult<ENTITY> entities = dao.get(criteriaQuery, criteria);
		return assembler.assemble(entities);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public PageResult<DTO> get(Field field, Criteria criteria) throws FieldNotFoundException {
		CriteriaQuery<ENTITY> criteriaQuery = createGetQuery(field);
		PageResult<ENTITY> entities = dao.get(criteriaQuery, criteria);
		return assembler.assemble(entities);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public PageResult<DTO> getLike(Field field, Criteria criteria) throws FieldNotFoundException {
		CriteriaQuery<ENTITY> criteriaQuery = createGetLikeQuery(field);
		PageResult<ENTITY> entities = dao.get(criteriaQuery, criteria);
		return assembler.assemble(entities);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public Long count(CriteriaQuery<Long> criteriaQuery, Criteria criteria) {
		criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(persistentClass)));
		return dao.count(criteriaQuery, criteria);
	}

	private CriteriaQuery<ENTITY> createGetQuery(Field field) {
		CriteriaQuery<ENTITY> criteriaQuery = criteriaBuilder.createQuery(persistentClass);
		Root<ENTITY> root = criteriaQuery.from(persistentClass);
		Predicate predicate = criteriaBuilder.equal(root.get(field.getName()), field.getValue());
		criteriaQuery.where(predicate);
		return criteriaQuery;
	}

	private CriteriaQuery<ENTITY> createGetLikeQuery(Field field) {
		CriteriaQuery<ENTITY> criteriaQuery = criteriaBuilder.createQuery(persistentClass);
		Root<ENTITY> root = criteriaQuery.from(persistentClass);
		Predicate predicate = criteriaBuilder.like(root.<String> get(field.getName()), "%" + field.getValue() + "%");
		criteriaQuery.where(predicate);
		return criteriaQuery;
	}
}
