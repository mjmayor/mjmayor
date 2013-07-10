package org.mjmayor.baseproject.controller;

import javax.validation.Valid;

import org.mjmayor.baseproject.constants.AsignaturaConstants;
import org.mjmayor.baseproject.constants.application.ApplicationConstants;
import org.mjmayor.baseproject.facade.AsignaturaFacade;
import org.mjmayor.baseproject.form.AsignaturaForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

//	@Autowired
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

	@RequestMapping(value = ApplicationConstants.DELETE, method = RequestMethod.POST)
	public String deleteAsignatura(AsignaturaForm asignaturaForm, BindingResult result) {
		logger.debug("AsignaturaController - deleteAsignatura");
		asignaturaFacade.removeAsignatura(asignaturaForm);
		return AsignaturaConstants.DELETEOK;
	}

	@RequestMapping(value = ApplicationConstants.GET_BY_COD, method = RequestMethod.POST)
	public ModelAndView getAsignaturaByCod(@Valid AsignaturaForm asignaturaForm, BindingResult result, ModelMap model) {
		logger.debug("AsignaturaController - getAsignaturaByCod");
		if (result.hasFieldErrors(AsignaturaConstants.Fields.CODIGO)) {
			model.addAttribute(AsignaturaConstants.ASIGNATURA_DATA, asignaturaForm);
			return new ModelAndView(AsignaturaConstants.FORM);
		} else {
			model.addAttribute(AsignaturaConstants.ASIGNATURA_DATA, asignaturaFacade.getAsignaturaByCod(asignaturaForm));
			return new ModelAndView(AsignaturaConstants.DATA, ApplicationConstants.MODEL, model);
		}
	}

	@RequestMapping(value = ApplicationConstants.GET_LIKE_COD, method = RequestMethod.POST)
	public ModelAndView getAsignaturaLikeCod(@Valid AsignaturaForm asignaturaForm, BindingResult result, ModelMap model) {
		logger.debug("AsignaturaController - getAsignaturaLikeCod");
		if (result.hasFieldErrors(AsignaturaConstants.Fields.CODIGO)) {
			model.addAttribute(AsignaturaConstants.ASIGNATURA_DATA, asignaturaForm);
			return new ModelAndView(AsignaturaConstants.FORM);
		} else {
			model.addAttribute(AsignaturaConstants.ASIGNATURAS_LIST_DATA, asignaturaFacade.getAsignaturasLikeCod(asignaturaForm));
			return new ModelAndView(AsignaturaConstants.LIST, ApplicationConstants.MODEL, model);
		}
	}

	@RequestMapping(value = ApplicationConstants.GET_LIKE_NAME, method = RequestMethod.POST)
	public ModelAndView getAsignaturaLikeName(@Valid AsignaturaForm asignaturaForm, BindingResult result, ModelMap model) {
		logger.debug("AsignaturaController - getAsignaturaLikeName");
		if (result.hasFieldErrors(AsignaturaConstants.Fields.NOMBRE)) {
			model.addAttribute(AsignaturaConstants.ASIGNATURA_DATA, asignaturaForm);
			return new ModelAndView(AsignaturaConstants.FORM);
		} else {
			model.addAttribute(AsignaturaConstants.ASIGNATURAS_LIST_DATA, asignaturaFacade.getAsignaturasLikeName(asignaturaForm));
			return new ModelAndView(AsignaturaConstants.LIST, ApplicationConstants.MODEL, model);
		}
	}

	@RequestMapping(value = ApplicationConstants.GET_LIKE_FIELDS, method = RequestMethod.POST)
	public ModelAndView getAsignaturaLikeFields(AsignaturaForm asignaturaForm, BindingResult result, ModelMap model) {
		logger.debug("AsignaturaController - getAsignaturaLikeFields");
		model.addAttribute(AsignaturaConstants.ASIGNATURAS_LIST_DATA, asignaturaFacade.getAsignaturas(asignaturaForm));
		return new ModelAndView(AsignaturaConstants.LIST, ApplicationConstants.MODEL, model);
	}
	
	@RequestMapping(value = ApplicationConstants.GETALL, method = RequestMethod.POST)
	public ModelAndView getAllAsignaturas(ModelMap model) {
		logger.debug("AlumnoController - getAllAlumnos");
		model.addAttribute(AsignaturaConstants.ASIGNATURAS_LIST_DATA, asignaturaFacade.getAsignaturas());
		return new ModelAndView(AsignaturaConstants.LIST, ApplicationConstants.MODEL, model);
	}
}
