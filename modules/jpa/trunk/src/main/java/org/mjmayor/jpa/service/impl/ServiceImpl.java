package org.mjmayor.jpa.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;

import org.mjmayor.jpa.assembler.BidirectionalAssembler;
import org.mjmayor.jpa.dao.DAO;
import org.mjmayor.jpa.dao.impl.DAOImpl;
import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.mjmayor.jpa.service.Service;
import org.mjmayor.jpa.support.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

public class ServiceImpl<ENTITY, DTO> implements Service<ENTITY, DTO> {

	private static final Logger logger = LoggerFactory.getLogger(DAOImpl.class);

	private DAO<ENTITY> dao;

	private EntityManager entityManager;

	private BidirectionalAssembler<ENTITY, DTO> assembler;

	public ServiceImpl(EntityManager entityManager, BidirectionalAssembler<ENTITY, DTO> assembler) {
		this.entityManager = entityManager;
		this.assembler = assembler;
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
		List<ENTITY> listEntity = dao.get(criteria);
		List<DTO> listDTO = new ArrayList<DTO>(assembler.assemble(listEntity));
		return listDTO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public Long countAll() {
		return dao.countAll();
	}

	@Override
	public DTO get(Long id) {
		ENTITY entity = dao.get(id);
		return assembler.assemble(entity);
	}

	@Override
	public List<DTO> getByField(String field, Object value, Criteria criteria) throws FieldNotFoundException {
		// TODO mjmayor Auto-generated method stub
		return null;
	}

	@Override
	public List<DTO> getLikeField(String field, String value, Criteria criteria) throws FieldNotFoundException {
		// TODO mjmayor Auto-generated method stub
		return null;
	}
}
