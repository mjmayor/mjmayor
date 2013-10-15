package org.mjmayor.jpa.service.impl;

import java.util.ArrayList;
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
import org.mjmayor.jpa.support.querybuilder.QueryBuilder;
import org.mjmayor.jpa.support.querybuilder.QueryParams;
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
		this.assembler = assembler;
		this.criteriaBuilder = entityManager.getCriteriaBuilder();
		this.persistentClass = persistentClass;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
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
	public void removeByField(String field, Object value) throws JPAPersistenceException, FieldNotFoundException {
		// TODO mjmayor Auto-generated method stub
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void removeLikeField(String field, String value) throws JPAPersistenceException, FieldNotFoundException {
		// TODO mjmayor Auto-generated method stub
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DTO> get(Criteria criteria) {
		QueryParams<ENTITY> queryParams = new QueryParams<ENTITY>(persistentClass);
		List<ENTITY> listEntity = dao.get(new QueryBuilder<ENTITY>(queryParams), criteria);
		List<DTO> listDTO = new ArrayList<DTO>(assembler.assemble(listEntity));
		return listDTO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public Long countAll() {
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(persistentClass)));
		return dao.count(criteriaQuery);
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
	public List<DTO> getByField(Field field, Criteria criteria) throws FieldNotFoundException {
		CriteriaQuery<ENTITY> criteriaQuery = criteriaBuilder.createQuery(persistentClass);
		Root<ENTITY> root = criteriaQuery.from(persistentClass);
		Predicate predicate = criteriaBuilder.equal(root.get(field.getName()), field.getValue());
		criteriaQuery.where(predicate);
		// List<ENTITY> list = dao.get(criteriaQuery, criteria);
		List<ENTITY> list = dao.get(null, criteria);
		return new ArrayList<DTO>(assembler.assemble(list));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DTO> getLikeField(Field field, Criteria criteria) throws FieldNotFoundException {
		CriteriaQuery<ENTITY> criteriaQuery = criteriaBuilder.createQuery(persistentClass);
		Root<ENTITY> root = criteriaQuery.from(persistentClass);
		Predicate predicate = criteriaBuilder.like(root.<String> get(field.getName()), "%" + field.getValue() + "%");
		criteriaQuery.where(predicate);
		// List<ENTITY> list = dao.get(criteriaQuery, criteria);
		List<ENTITY> list = dao.get(null, criteria);
		return new ArrayList<DTO>(assembler.assemble(list));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DTO> get(QueryBuilder<ENTITY> queryBuilder, Criteria criteria) {
		List<ENTITY> list = dao.get(queryBuilder, criteria);
		return new ArrayList<DTO>(assembler.assemble(list));
	}
}
