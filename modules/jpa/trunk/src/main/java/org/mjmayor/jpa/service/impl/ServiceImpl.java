package org.mjmayor.jpa.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.hibernate.Criteria;
import org.mjmayor.jpa.assembler.BidirectionalAssembler;
import org.mjmayor.jpa.dao.DAO;
import org.mjmayor.jpa.dao.impl.DAOImpl;
import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.mjmayor.jpa.facade.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

public class ServiceImpl<DTO, ENTITY> implements Service<DTO, ENTITY> {

	private static final Logger logger = LoggerFactory.getLogger(DAOImpl.class);

	private DAO<ENTITY> dao;

	private BidirectionalAssembler<ENTITY, DTO> assembler;

	public ServiceImpl(DAO<ENTITY> dao, BidirectionalAssembler<ENTITY, DTO> assembler) {
		this.dao = dao;
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
		dao.removeByField(field, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void removeLikeField(String field, String value) throws JPAPersistenceException, FieldNotFoundException {
		dao.removeByField(field, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DTO> getAll() {
		List<ENTITY> listEntity = dao.getAll();
		List<DTO> listDTO = new ArrayList<DTO>(assembler.assemble(listEntity));
		return listDTO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public long countAll() {
		return dao.countAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DTO> getByField(String field, Object value) throws FieldNotFoundException {
		List<ENTITY> listEntity = dao.getByField(field, value);
		List<DTO> listDTO = new ArrayList<DTO>(assembler.assemble(listEntity));
		return listDTO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DTO> getLikeField(String field, String value) throws FieldNotFoundException {
		List<ENTITY> listEntity = dao.getLikeField(field, value);
		List<DTO> listDTO = new ArrayList<DTO>(assembler.assemble(listEntity));
		return listDTO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DTO> getByCriteria(Criteria criteria) throws FieldNotFoundException {
		List<ENTITY> listEntity = dao.getByCriteria(criteria);
		List<DTO> listDTO = new ArrayList<DTO>(assembler.assemble(listEntity));
		return listDTO;
	}
}
