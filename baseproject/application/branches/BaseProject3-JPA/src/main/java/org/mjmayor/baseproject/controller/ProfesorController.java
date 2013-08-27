package org.mjmayor.baseproject.controller;

import javax.validation.Valid;

import org.mjmayor.baseproject.constants.ProfesorConstants;
import org.mjmayor.baseproject.constants.application.ApplicationConstants;
import org.mjmayor.baseproject.facade.ProfesorFacade;
import org.mjmayor.baseproject.form.ProfesorForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(ProfesorConstants.PATH)
public class ProfesorController {

	private static final Logger logger = LoggerFactory.getLogger(AsignaturaController.class);

	@Autowired
	private ProfesorFacade profesorFacade;

	@RequestMapping(value = ApplicationConstants.FORM, method = RequestMethod.GET)
	public String showProfesorForm(ModelMap model) {
		logger.debug("ProfesorController - showProfesorForm");
		model.addAttribute(ProfesorConstants.PROFESOR_DATA, new ProfesorForm());
		return ProfesorConstants.FORM;
	}

	@RequestMapping(value = ApplicationConstants.INSERT, method = RequestMethod.POST)
	public String insertProfesor(@Valid ProfesorForm profesorForm, BindingResult result) {
		logger.debug("ProfesorController - insertProfesor");

		if (result.hasErrors()) {
			return ProfesorConstants.FORM;
		} else {
			profesorFacade.addProfesor(profesorForm);
			return ProfesorConstants.INSERTOK;
		}
	}

	@RequestMapping(value = ApplicationConstants.DELETE, method = RequestMethod.POST)
	public String deleteProfesor(@Valid ProfesorForm profesorForm, BindingResult result) {
		logger.debug("ProfesorController - deleteProfesor");

		if (result.hasFieldErrors(ProfesorConstants.Fields.DNI)) {
			return ProfesorConstants.FORM;
		} else {
			profesorFacade.removeProfesor(profesorForm);
			return ProfesorConstants.DELETEOK;
		}
	}

	@RequestMapping(value = ApplicationConstants.GET, method = RequestMethod.POST)
	public ModelAndView getProfesor(@Valid ProfesorForm profesorForm, BindingResult result, ModelMap model) {
		logger.debug("ProfesorController - getProfesor");

		if (result.hasFieldErrors(ProfesorConstants.Fields.DNI)) {
			model.addAttribute(ProfesorConstants.PROFESOR_DATA, profesorForm);
			return new ModelAndView(ProfesorConstants.FORM);
		} else {
			model.addAttribute(ProfesorConstants.PROFESOR_DATA, profesorFacade.getProfesor(profesorForm));
			return new ModelAndView(ProfesorConstants.DATA, ApplicationConstants.MODEL, model);
		}
	}

	@RequestMapping(value = ApplicationConstants.GETALL, method = RequestMethod.POST)
	public ModelAndView getAllProfesores(ModelMap model) {
		logger.debug("ProfesorController - getAllProfesores");
		model.addAttribute(ProfesorConstants.PROFESORES_LIST_DATA, profesorFacade.getProfesores());
		return new ModelAndView(ProfesorConstants.LIST, ApplicationConstants.MODEL, model);
	}
}
