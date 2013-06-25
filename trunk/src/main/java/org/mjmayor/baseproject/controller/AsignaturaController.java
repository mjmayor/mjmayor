package org.mjmayor.baseproject.controller;

import javax.validation.Valid;

import org.mjmayor.baseproject.constants.AsignaturaConstants;
import org.mjmayor.baseproject.constants.application.ApplicationConstants;
import org.mjmayor.baseproject.facade.AsignaturaFacade;
import org.mjmayor.baseproject.form.AsignaturaForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(AsignaturaConstants.PATH)
public class AsignaturaController {

	private static final Logger logger = LoggerFactory.getLogger(AsignaturaController.class);

	@Autowired
	private AsignaturaFacade asignaturaFacade;

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
		} else {
			asignaturaFacade.addAsignatura(asignaturaForm);
			return AsignaturaConstants.INSERTOK;
		}
	}
}
