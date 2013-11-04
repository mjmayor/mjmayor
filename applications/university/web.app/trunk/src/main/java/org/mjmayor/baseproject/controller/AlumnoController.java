package org.mjmayor.baseproject.controller;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.mjmayor.baseproject.assembler.alumno.AlumnoFormAssembler;
import org.mjmayor.baseproject.constants.AlumnoConstants;
import org.mjmayor.baseproject.constants.application.ApplicationConstants;
import org.mjmayor.baseproject.facade.AlumnoFacade;
import org.mjmayor.baseproject.form.AlumnoForm;
import org.mjmayor.baseproject.view.AlumnoView;
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
@RequestMapping(AlumnoConstants.PATH)
public class AlumnoController {

	private static final Logger logger = LoggerFactory.getLogger(AsignaturaController.class);

	private AlumnoFacade facade;

	private AlumnoFormAssembler assembler;

	@Autowired
	public void setFacade(AlumnoFacade facade) {
		this.facade = facade;
	}

	@Autowired
	public void setAssembler(AlumnoFormAssembler assembler) {
		this.assembler = assembler;
	}

	@RequestMapping(value = ApplicationConstants.FORM, method = RequestMethod.GET)
	public String showAlumnoForm(ModelMap model) {
		logger.debug("AlumnoController - showAlumnoForm");
		model.addAttribute(AlumnoConstants.ALUMNO_DATA, new AlumnoForm());
		return AlumnoConstants.FORM;
	}

	@RequestMapping(value = ApplicationConstants.INSERT, method = RequestMethod.POST)
	public String insertAlumno(@Valid AlumnoForm alumnoForm, BindingResult result) {
		logger.debug("AlumnoController - insertAlumno");

		if (result.hasErrors()) {
			return AlumnoConstants.FORM;
		}
		try {
			facade.add(assembler.assemble(alumnoForm));
		} catch (ConstraintViolationException e) {
			return AlumnoConstants.INSERT_ERROR;
		} catch (JpaSystemException e) {
			return AlumnoConstants.INSERT_ERROR;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AlumnoConstants.INSERT_OK;
	}

	@RequestMapping(value = ApplicationConstants.DELETE, method = RequestMethod.POST)
	public String deleteAlumno(@Valid AlumnoForm alumnoForm, BindingResult result) {
		logger.debug("AlumnoController - deleteAlumno");

		if (result.hasFieldErrors(AlumnoConstants.Fields.DNI)) {
			return AlumnoConstants.FORM;
		}
		try {
			Field field = new Field(AlumnoConstants.Fields.DNI, alumnoForm.getDni());
			facade.delete(field);
		} catch (FieldNotFoundException e) {
			return AlumnoConstants.DELETE_ERROR;
		}
		return AlumnoConstants.DELETE_OK;
	}

	@RequestMapping(value = ApplicationConstants.GET, method = RequestMethod.POST)
	public ModelAndView getAlumno(@Valid AlumnoForm alumnoForm, BindingResult result, ModelMap model) {
		logger.debug("AlumnoController - getAlumno");

		if (result.hasFieldErrors(AlumnoConstants.Fields.DNI)) {
			model.addAttribute(AlumnoConstants.ALUMNO_DATA, alumnoForm);
			return new ModelAndView(AlumnoConstants.FORM);
		}
		try {
			PageResult<AlumnoView> alumno = facade.getByDNI(alumnoForm.getDni());
			AlumnoView alumnoView = null;
			if (alumno.getItems().size() > 0) {
				alumnoView = alumno.getItems().get(0);
			} else {
				alumnoView = new AlumnoView();
			}
			model.addAttribute(AlumnoConstants.ALUMNO_DATA, alumnoView);

		} catch (FieldNotFoundException e) {
			return new ModelAndView(AlumnoConstants.DATA_ERROR);
		}
		return new ModelAndView(AlumnoConstants.DATA, ApplicationConstants.MODEL, model);
	}

	@RequestMapping(value = ApplicationConstants.GETALL, method = RequestMethod.POST)
	public ModelAndView getAllAlumnos(ModelMap model) {
		logger.debug("AlumnoController - getAllAlumnos");
		Criteria criteria = null;
		model.addAttribute(AlumnoConstants.ALUMNOS_LIST_DATA, facade.get(criteria));
		return new ModelAndView(AlumnoConstants.LIST, ApplicationConstants.MODEL, model);
	}
}
