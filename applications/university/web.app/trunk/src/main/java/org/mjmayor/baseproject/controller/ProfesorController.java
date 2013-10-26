package org.mjmayor.baseproject.controller;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.mjmayor.baseproject.assembler.profesor.ProfesorFormAssembler;
import org.mjmayor.baseproject.constants.ProfesorConstants;
import org.mjmayor.baseproject.constants.application.ApplicationConstants;
import org.mjmayor.baseproject.facade.ProfesorFacade;
import org.mjmayor.baseproject.form.ProfesorForm;
import org.mjmayor.baseproject.view.ProfesorView;
import org.mjmayor.jpa.exceptions.FieldNotFoundException;
import org.mjmayor.jpa.support.Criteria;
import org.mjmayor.jpa.support.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
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

	private ProfesorFacade profesorFacade;

	private ProfesorFormAssembler assembler;

	@Autowired
	public void setProfesorFacade(ProfesorFacade profesorFacade) {
		this.profesorFacade = profesorFacade;
	}

	@Autowired
	public void setAssembler(ProfesorFormAssembler assembler) {
		this.assembler = assembler;
	}

	@RequestMapping(value = ApplicationConstants.FORM, method = RequestMethod.GET)
	public String showProfesorForm(ModelMap model) {
		logger.debug("ProfesorController - showProfesorForm");
		model.addAttribute(ProfesorConstants.PROFESOR_DATA, new ProfesorForm());
		return ProfesorConstants.FORM;
	}

	@RequestMapping(value = ApplicationConstants.INSERT, method = RequestMethod.POST)
	public String insertProfesor(@Valid ProfesorForm profesorForm, BindingResult result) {
		if (result.hasErrors()) {
			return ProfesorConstants.FORM;
		}
		try {
			profesorFacade.add(assembler.assemble(profesorForm));
		} catch (ConstraintViolationException e) {
			return ProfesorConstants.INSERT_ERROR;
		} catch (JpaSystemException e) {
			return ProfesorConstants.INSERT_ERROR;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ProfesorConstants.INSERT_OK;
	}

	@RequestMapping(value = ApplicationConstants.DELETE, method = RequestMethod.POST)
	public String deleteProfesor(@Valid ProfesorForm profesorForm, BindingResult result) {
		logger.debug("ProfesorController - deleteProfesor");

		// if (result.hasFieldErrors(ProfesorConstants.Fields.DNI)) {
		// return ProfesorConstants.FORM;
		// } else {
		// try {
		// profesorFacade.removeByField(ProfesorConstants.Fields.DNI, profesorForm.getDni());
		// } catch (FieldNotFoundException e) {
		// return ProfesorConstants.DELETE_ERROR;
		// }
		// return ProfesorConstants.DELETE_OK;
		// }

		return "";
	}

	@RequestMapping(value = ApplicationConstants.GET, method = RequestMethod.POST)
	public ModelAndView getProfesor(@Valid ProfesorForm profesorForm, BindingResult result, ModelMap model) {
		logger.debug("ProfesorController - getProfesor");

		if (result.hasFieldErrors(ProfesorConstants.Fields.DNI)) {
			model.addAttribute(ProfesorConstants.PROFESOR_DATA, profesorForm);
			return new ModelAndView(ProfesorConstants.FORM);
		} else {
			try {
				PageResult<ProfesorView> profesor = profesorFacade.getByDNI(profesorForm.getDni());
				ProfesorView profesorView = null;
				if (profesor.getItems().size() > 0) {
					profesorView = profesor.getItems().get(0);
				} else {
					profesorView = new ProfesorView();
				}
				model.addAttribute(ProfesorConstants.PROFESOR_DATA, profesorView);

			} catch (FieldNotFoundException e) {
				return new ModelAndView(ProfesorConstants.DATA_ERROR);
			}
			return new ModelAndView(ProfesorConstants.DATA, ApplicationConstants.MODEL, model);
		}
	}

	@RequestMapping(value = ApplicationConstants.GETALL, method = RequestMethod.POST)
	public ModelAndView getAllProfesores(ModelMap model) {
		logger.debug("ProfesorController - getAllProfesores");
		Criteria criteria = null;
		model.addAttribute(ProfesorConstants.PROFESORES_LIST_DATA, profesorFacade.get(criteria));
		return new ModelAndView(ProfesorConstants.LIST, ApplicationConstants.MODEL, model);
	}
}
