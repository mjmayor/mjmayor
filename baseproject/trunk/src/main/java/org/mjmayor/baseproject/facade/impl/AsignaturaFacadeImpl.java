package org.mjmayor.baseproject.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.mjmayor.baseproject.assembler.asignatura.AsignaturaViewAssembler;
import org.mjmayor.baseproject.constants.AsignaturaConstants;
import org.mjmayor.baseproject.dao.AsignaturaDAO;
import org.mjmayor.baseproject.dto.AsignaturaDTO;
import org.mjmayor.baseproject.facade.AsignaturaFacade;
import org.mjmayor.baseproject.form.AsignaturaForm;
import org.mjmayor.baseproject.view.AsignaturaView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

public class AsignaturaFacadeImpl implements AsignaturaFacade {

	private static final Logger logger = LoggerFactory.getLogger(AsignaturaFacadeImpl.class);

	private AsignaturaDAO asignaturaDAO;

	private AsignaturaViewAssembler asignaturaViewAssembler;

	public AsignaturaFacadeImpl(AsignaturaDAO asignaturaDAO, AsignaturaViewAssembler asignaturaAssembler) {
		super();
		this.asignaturaDAO = asignaturaDAO;
		this.asignaturaViewAssembler = asignaturaAssembler;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void addAsignatura(AsignaturaForm asignaturaForm) {
		logger.debug("AlumnoFacadeImpl - addAsignatura");
		asignaturaDAO.addAsignatura(asignaturaForm);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<AsignaturaView> getAsignaturas() {
		logger.debug("AsignaturaFacadeImpl - getAsignaturas");
		List<AsignaturaDTO> listaDTO = asignaturaDAO.getAsignaturas();
		List<AsignaturaView> listaView = new ArrayList<AsignaturaView>(asignaturaViewAssembler.assemble(listaDTO));
		return listaView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public AsignaturaView getAsignaturaByCod(AsignaturaForm asignaturaForm) {
		logger.debug("AsignaturaFacadeImpl - getAsignaturaByCod");
		List<AsignaturaDTO> listaDTO = asignaturaDAO.getAsignaturasByField(AsignaturaConstants.Fields.CODIGO, asignaturaForm.getCodigo());
		AsignaturaView asignaturaView = new AsignaturaView();

		if (listaDTO.size() > 0) {
			asignaturaView = asignaturaViewAssembler.assemble(listaDTO.get(0));
		}
		return asignaturaView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<AsignaturaView> getAsignaturasLikeCod(AsignaturaForm asignaturaForm) {
		logger.debug("AsignaturaFacadeImpl - getAsignaturaByCod");
		return getAsignaturasLikeField(AsignaturaConstants.Fields.CODIGO, asignaturaForm.getCodigo());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<AsignaturaView> getAsignaturasLikeName(AsignaturaForm asignaturaForm) {
		logger.debug("AsignaturaFacadeImpl - getAsignaturaByCod");
		return getAsignaturasLikeField(AsignaturaConstants.Fields.NOMBRE, asignaturaForm.getNombre());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<AsignaturaView> getAsignaturas(AsignaturaForm asignaturaForm) {
		logger.debug("AsignaturaFacadeImpl - getAsignaturas");
		List<AsignaturaDTO> listaDTO = asignaturaDAO.getAsignaturas(asignaturaForm);
		List<AsignaturaView> listaView = new ArrayList<AsignaturaView>(asignaturaViewAssembler.assemble(listaDTO));
		return listaView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void removeAsignatura(AsignaturaForm asignaturaForm) {
		logger.debug("AsignaturaFacadeImpl - removeAsignatura");
		asignaturaDAO.removeAsignatura(asignaturaForm);
	}

	/**
	 * Recupera un listado de asignaturas a partir de un campo y un valor, buscando de forma aproximada
	 * 
	 * @param field
	 *            Campo por el que buscar
	 * @param value
	 *            Valor a buscar
	 * @return Listado de asignaturas que corresponden al criterio de busqueda
	 */
	private List<AsignaturaView> getAsignaturasLikeField(String field, Object value) {
		List<AsignaturaDTO> listaDTO = asignaturaDAO.getAsignaturasLikeField(field, value);
		List<AsignaturaView> listaView = new ArrayList<AsignaturaView>(asignaturaViewAssembler.assemble(listaDTO));
		return listaView;
	}
}
