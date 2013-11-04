package org.mjmayor.baseproject.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.mjmayor.baseproject.assembler.alumno.AlumnoViewAssembler;
import org.mjmayor.baseproject.constants.AlumnoConstants;
import org.mjmayor.baseproject.facade.AlumnoFacade;
import org.mjmayor.baseproject.view.AlumnoView;
import org.mjmayor.jpa.facade.Facade;
import org.mjmayor.jpa.service.Service;
import org.mjmayor.jpa.support.Criteria;
import org.mjmayor.jpa.support.Field;
import org.mjmayor.jpa.support.PageResult;
import org.mjmayor.model.dto.AlumnoDTO;
import org.mjmayor.model.entity.Alumno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlumnoFacadeImpl extends Facade implements AlumnoFacade {

	private static final Logger logger = LoggerFactory.getLogger(AlumnoFacadeImpl.class);

	private Service<Alumno, AlumnoDTO> service;

	private AlumnoViewAssembler assembler;

	public AlumnoFacadeImpl(Service<Alumno, AlumnoDTO> service, AlumnoViewAssembler assembler) {
		super(service);
		this.service = service;
		this.assembler = assembler;
	}

	@Override
	public void add(AlumnoDTO alumnoDTO) {
		service.add(alumnoDTO);
	}

	@Override
	public void update(AlumnoDTO alumnoDTO) {
		service.update(alumnoDTO);

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
	public AlumnoView get(Long id) {
		AlumnoDTO dto = service.get(id);
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
	public PageResult<AlumnoView> get(Criteria criteria) {
		CriteriaQuery<Alumno> criteriaQuery = criteriaBuilder.createQuery(Alumno.class);
		criteriaQuery.from(Alumno.class);
		PageResult<AlumnoDTO> list = service.get(criteriaQuery, criteria);
		return assembler.assemble(list);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PageResult<AlumnoView> getByDNI(String dni) {
		PageResult<AlumnoDTO> list = service.get(new Field(AlumnoConstants.Fields.DNI, dni), null);
		return assembler.assemble(list);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PageResult<AlumnoView> getLikeName(String name, Criteria criteria) {
		PageResult<AlumnoDTO> list = service.getLike(new Field(AlumnoConstants.Fields.NAME, name), criteria);
		return assembler.assemble(list);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PageResult<AlumnoView> getLikeSurname(String surname, Criteria criteria) {
		PageResult<AlumnoDTO> list = service.getLike(new Field(AlumnoConstants.Fields.SURNAME, surname), criteria);
		return assembler.assemble(list);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PageResult<AlumnoView> getAlphabeticalList(Criteria criteria) {
		CriteriaQuery<Alumno> criteriaQuery = criteriaBuilder.createQuery(Alumno.class);
		Root<Alumno> root = criteriaQuery.from(Alumno.class);
		List<Order> orders = new ArrayList<Order>();
		orders.add(criteriaBuilder.asc(root.get("apellidos")));
		orders.add(criteriaBuilder.asc(root.get("nombre")));
		criteriaQuery.orderBy(orders);
		PageResult<AlumnoDTO> list = service.get(criteriaQuery, criteria);
		return assembler.assemble(list);
	}
}
