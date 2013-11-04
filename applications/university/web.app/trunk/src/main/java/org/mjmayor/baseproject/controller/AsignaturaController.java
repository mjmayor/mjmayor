package org.mjmayor.baseproject.controller;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.mjmayor.baseproject.assembler.asignatura.AsignaturaFormAssembler;
import org.mjmayor.baseproject.constants.AsignaturaConstants;
import org.mjmayor.baseproject.constants.application.ApplicationConstants;
import org.mjmayor.baseproject.facade.AsignaturaFacade;
import org.mjmayor.baseproject.form.AsignaturaForm;
import org.mjmayor.baseproject.view.AsignaturaView;
import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.support.Criteria;
import org.mjmayor.jpa.support.Field;
import org.mjmayor.jpa.support.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(AsignaturaConstants.PATH)
public class AsignaturaController {

	private static final Logger logger = LoggerFactory.getLogger(AsignaturaController.class);

	private AsignaturaFacade facade;

	private AsignaturaFormAssembler assembler;

	@Autowired
	public void setFacade(AsignaturaFacade facade) {
		this.facade = facade;
	}

	@Autowired
	public void setAssembler(AsignaturaFormAssembler assembler) {
		this.assembler = assembler;
	}

	@RequestMapping(value = ApplicationConstants.FORM, method = RequestMethod.GET)
	public String showAsignaturaForm(ModelMap model) {
		logger.debug("AsignaturaController - showAsignaturaForm");
		model.addAttribute(AsignaturaConstants.ASIGNATURA_DATA, new AsignaturaForm());
		return AsignaturaConstants.FORM;
	}

	@RequestMapping(value = ApplicationConstants.INSERT, method = RequestMethod.POST)
	public String insertAsignatura(@Valid AsignaturaForm asignaturaForm, BindingResult result) {
		logger.debug("AsignaturaController - insertAsignatura");

		if (result.hasErrors()) {
			return AsignaturaConstants.FORM;
		}
		try {
			facade.add(assembler.assemble(asignaturaForm));
		} catch (ConstraintViolationException e) {
			return AsignaturaConstants.INSERT_ERROR;
		} catch (JpaSystemException e) {
			return AsignaturaConstants.INSERT_ERROR;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AsignaturaConstants.INSERT_OK;
	}

	@RequestMapping(value = ApplicationConstants.DELETE, method = RequestMethod.POST)
	public String deleteAsignatura(AsignaturaForm asignaturaForm, BindingResult result) {
		logger.debug("AsignaturaController - deleteAsignatura");

		if (result.hasFieldErrors(AsignaturaConstants.Fields.CODE)) {
			return AsignaturaConstants.FORM;
		}
		try {
			Field field = new Field(AsignaturaConstants.Fields.CODE, asignaturaForm.getCodigo());
			facade.delete(field);
		} catch (FieldNotFoundException e) {
			return AsignaturaConstants.DELETE_ERROR;
		}
		return AsignaturaConstants.DELETE_OK;
	}

	@RequestMapping(value = ApplicationConstants.GET, method = RequestMethod.POST)
	public ModelAndView getAsignaturaByCod(@Valid AsignaturaForm asignaturaForm, BindingResult result, ModelMap model) {
		logger.debug("AsignaturaController - getAsignaturaByCod");

		if (result.hasFieldErrors(AsignaturaConstants.Fields.CODE)) {
			model.addAttribute(AsignaturaConstants.ASIGNATURA_DATA, asignaturaForm);
			return new ModelAndView(AsignaturaConstants.FORM);
		}
		try {
			PageResult<AsignaturaView> asignatura = facade.getByCode(asignaturaForm.getCodigo());
			AsignaturaView asignaturaView = null;
			if (asignatura.getItems().size() > 0) {
				asignaturaView = asignatura.getItems().get(0);
			} else {
				asignaturaView = new AsignaturaView();
			}
			model.addAttribute(AsignaturaConstants.ASIGNATURA_DATA, asignaturaView);

		} catch (FieldNotFoundException e) {
			return new ModelAndView(AsignaturaConstants.DATA_ERROR);
		}
		return new ModelAndView(AsignaturaConstants.DATA, ApplicationConstants.MODEL, model);
	}

	@RequestMapping(value = ApplicationConstants.GETALL, method = RequestMethod.POST)
	public ModelAndView getAllAsignaturas(ModelMap model) {
		logger.debug("AlumnoController - getAllAlumnos");
		Criteria criteria = null;
		model.addAttribute(AsignaturaConstants.ASIGNATURAS_LIST_DATA, facade.get(criteria));
		return new ModelAndView(AsignaturaConstants.LIST, ApplicationConstants.MODEL, model);
	}
}
