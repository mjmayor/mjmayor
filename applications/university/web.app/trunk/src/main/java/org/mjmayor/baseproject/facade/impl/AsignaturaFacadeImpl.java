package org.mjmayor.baseproject.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.mjmayor.baseproject.assembler.asignatura.AsignaturaViewAssembler;
import org.mjmayor.baseproject.constants.AsignaturaConstants;
import org.mjmayor.baseproject.facade.AsignaturaFacade;
import org.mjmayor.baseproject.view.AsignaturaView;
import org.mjmayor.jpa.facade.Facade;
import org.mjmayor.jpa.service.Service;
import org.mjmayor.jpa.support.Criteria;
import org.mjmayor.jpa.support.Field;
import org.mjmayor.jpa.support.PageResult;
import org.mjmayor.model.dto.AsignaturaDTO;
import org.mjmayor.model.entity.Asignatura;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsignaturaFacadeImpl extends Facade implements AsignaturaFacade {

	private static final Logger logger = LoggerFactory.getLogger(AsignaturaFacadeImpl.class);

	private Service<Asignatura, AsignaturaDTO> service;

	private AsignaturaViewAssembler assembler;

	public AsignaturaFacadeImpl(Service<Asignatura, AsignaturaDTO> service, AsignaturaViewAssembler assembler) {
		super(service);
		this.service = service;
		this.assembler = assembler;
	}

	@Override
	public void add(AsignaturaDTO asignaturaDTO) {
		service.add(asignaturaDTO);
	}

	@Override
	public void update(AsignaturaDTO asignaturaDTO) {
		service.update(asignaturaDTO);

	}

	@Override
	public void delete(Long id) {
		service.delete(id);
	}

	@Override
	public void delete(Field field) {
		service.delete(field);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AsignaturaView get(Long id) {
		AsignaturaDTO dto = service.get(id);
		return assembler.assemble(dto);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long countAll() {
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		return service.count(criteriaQuery, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PageResult<AsignaturaView> get(Criteria criteria) {
		CriteriaQuery<Asignatura> criteriaQuery = criteriaBuilder.createQuery(Asignatura.class);
		criteriaQuery.from(Asignatura.class);
		PageResult<AsignaturaDTO> list = service.get(criteriaQuery, criteria);
		return assembler.assemble(list);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PageResult<AsignaturaView> getByCode(String code) {
		PageResult<AsignaturaDTO> list = service.get(new Field(AsignaturaConstants.Fields.CODE, code), null);
		return assembler.assemble(list);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PageResult<AsignaturaView> getAlphabeticalList(Criteria criteria) {
		CriteriaQuery<Asignatura> criteriaQuery = criteriaBuilder.createQuery(Asignatura.class);
		Root<Asignatura> root = criteriaQuery.from(Asignatura.class);
		List<Order> orders = new ArrayList<Order>();
		orders.add(criteriaBuilder.asc(root.get("nombre")));
		criteriaQuery.orderBy(orders);
		PageResult<AsignaturaDTO> list = service.get(criteriaQuery, criteria);
		return assembler.assemble(list);
	}
}
