package org.mjmayor.jpa.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.mjmayor.jpa.assembler.Assembler;
import org.mjmayor.jpa.dao.DAO;
import org.mjmayor.jpa.dao.impl.DAOImpl;
import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.exceptions.JPAPersistenceException;
import org.mjmayor.jpa.facade.Facade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

public class FacadeImpl<FORM, DTO, VIEW> implements Facade<FORM, DTO, VIEW> {

	private static final Logger logger = LoggerFactory.getLogger(DAOImpl.class);

	private DAO<FORM, DTO> dao;

	private Assembler<FORM, DTO> formAssembler;

	private Assembler<DTO, VIEW> viewAssembler;

	public FacadeImpl(DAO<FORM, DTO> dao, Assembler<FORM, DTO> formAssembler, Assembler<DTO, VIEW> viewAssembler) {
		this.dao = dao;
		this.formAssembler = formAssembler;
		this.viewAssembler = viewAssembler;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void add(FORM form) throws ConstraintViolationException, JPAPersistenceException {
		DTO dto = formAssembler.assemble(form);
		dao.add(dto);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void removeById(int id) throws JPAPersistenceException {
		dao.removeById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void update(FORM form) throws JPAPersistenceException {
		DTO dto = formAssembler.assemble(form);
		dao.update(dto);
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
	@Transactional(readOnly=true)
	public List<VIEW> getAll() {
		List<DTO> listDTO = dao.getAll();
		List<VIEW> listView = new ArrayList<VIEW>(viewAssembler.assemble(listDTO));
		return listView;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly=true)
	public long countAll(){
		return dao.countAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly=true)
	public VIEW getById(int id) {
		DTO dto = dao.getById(id);
		VIEW view = viewAssembler.assemble(dto);
		return view;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly=true)
	public List<VIEW> getByField(String field, Object value) throws FieldNotFoundException {
		List<DTO> listDTO = dao.getByField(field, value);
		List<VIEW> listView = new ArrayList<VIEW>(viewAssembler.assemble(listDTO));
		return listView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly=true)
	public List<VIEW> getLikeField(String field, String value) throws FieldNotFoundException {
		List<DTO> listDTO = dao.getLikeField(field, value);
		List<VIEW> listView = new ArrayList<VIEW>(viewAssembler.assemble(listDTO));
		return listView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly=true)
	public List<VIEW> getLikeAllFields(FORM form) throws FieldNotFoundException {
		List<DTO> listDTO = dao.getLikeAllFields(form);
		List<VIEW> listView = new ArrayList<VIEW>(viewAssembler.assemble(listDTO));
		return listView;
	}
}
