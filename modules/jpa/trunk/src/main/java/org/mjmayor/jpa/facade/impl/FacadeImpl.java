package org.mjmayor.jpa.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.mjmayor.jpa.assembler.Assembler;
import org.mjmayor.jpa.dao.DAO;
import org.mjmayor.jpa.dao.impl.DAOImpl;
import org.mjmayor.jpa.facade.Facade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FacadeImpl<FORM, DTO, VIEW> implements Facade<FORM, DTO, VIEW> {

	private static final Logger logger = LoggerFactory.getLogger(DAOImpl.class);

	private DAO<FORM, DTO> dao;

	private Assembler<DTO, VIEW> assembler;

	public FacadeImpl(DAO<FORM, DTO> dao, Assembler<DTO, VIEW> assembler) {
		this.dao = dao;
		this.assembler = assembler;
	}

	/**
	 * {@inheritDoc}
	 */
	public void add(FORM form) {
		dao.add(form);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeById(int id) {
		dao.removeById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeByField(String field, Object value) {
		dao.removeByField(field, value);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeLikeField(String field, String value) {
		dao.removeByField(field, value);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<VIEW> getAll() {
		// TODO Auto-generated method stub
		List<DTO> listDTO = dao.getAll();
		List<VIEW> listView = new ArrayList<VIEW>(assembler.assemble(listDTO));
		return listView;
	}

	/**
	 * {@inheritDoc}
	 */
	public VIEW getById(int id) {
		DTO dto = dao.getById(id);
		VIEW view = assembler.assemble(dto);
		return view;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<VIEW> getByField(String field, Object value) {
		List<DTO> listDTO = dao.getByField(field, value);
		List<VIEW> listView = new ArrayList<VIEW>(assembler.assemble(listDTO));
		return listView;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<VIEW> getLikeField(String field, String value) {
		List<DTO> listDTO = dao.getLikeField(field, value);
		List<VIEW> listView = new ArrayList<VIEW>(assembler.assemble(listDTO));
		return listView;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<VIEW> getLikeAllFields(FORM form) {
		List<DTO> listDTO = dao.getLikeAllFields(form);
		List<VIEW> listView = new ArrayList<VIEW>(assembler.assemble(listDTO));
		return listView;
	}
}
