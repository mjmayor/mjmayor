package org.mjmayor.baseproject.controller;

import javax.validation.Valid;

import org.mjmayor.baseproject.constants.AlumnoConstants;
import org.mjmayor.baseproject.constants.application.ApplicationConstants;
import org.mjmayor.baseproject.facade.AlumnoFacade;
import org.mjmayor.baseproject.form.AlumnoForm;
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
@RequestMapping(AlumnoConstants.PATH)
public class AlumnoController {

    private static final Logger logger = LoggerFactory.getLogger(AsignaturaController.class);

    @Autowired
    private AlumnoFacade alumnoFacade;

    @RequestMapping(value = ApplicationConstants.FORM, method = RequestMethod.GET)
    public String showAlumnoForm(ModelMap model) {

	logger.info("AlumnoController - showAlumnoForm");

	model.addAttribute(AlumnoConstants.ALUMNO_DATA, new AlumnoForm());
	return AlumnoConstants.FORM;
    }

    @RequestMapping(value = ApplicationConstants.INSERT, method = RequestMethod.POST)
    public String insertAlumno(@Valid AlumnoForm alumnoForm, BindingResult result) {

	logger.info("AlumnoController - insertAlumno");

	if (result.hasErrors()) {
	    return AlumnoConstants.FORM;
	} else {
	    alumnoFacade.addAlumno(alumnoForm);
	    return AlumnoConstants.INSERTOK;
	}
    }

    @RequestMapping(value = ApplicationConstants.DELETE, method = RequestMethod.POST)
    public String deleteAlumno(@Valid AlumnoForm alumnoForm, BindingResult result) {

	logger.info("AlumnoController - deleteAlumno");

	if (result.hasFieldErrors(AlumnoConstants.Fields.DNI)) {
	    return AlumnoConstants.FORM;
	} else {
	    alumnoFacade.removeAlumno(alumnoForm);
	    return AlumnoConstants.DELETEOK;
	}
    }

    @RequestMapping(value = ApplicationConstants.GET, method = RequestMethod.POST)
    public ModelAndView getAlumno(@Valid AlumnoForm alumnoForm, BindingResult result, ModelMap model) {

	logger.info("AlumnoController - getAlumno");

	if (result.hasFieldErrors(AlumnoConstants.Fields.DNI)) {
	    model.addAttribute(AlumnoConstants.ALUMNO_DATA, alumnoForm);
	    return new ModelAndView(AlumnoConstants.FORM);
	} else {
	    model.addAttribute(AlumnoConstants.ALUMNO_DATA, alumnoFacade.getAlumno(alumnoForm));
	    return new ModelAndView(AlumnoConstants.DATA, ApplicationConstants.MODEL, model);
	}
    }

    @RequestMapping(value = ApplicationConstants.GETALL, method = RequestMethod.POST)
    public ModelAndView getAllAlumnos(ModelMap model) {

	logger.info("AlumnoController - getAllAlumnos");

	model.addAttribute(AlumnoConstants.ALUMNOS_LIST_DATA, alumnoFacade.getAlumnos());
	return new ModelAndView(AlumnoConstants.LIST, ApplicationConstants.MODEL, model);
    }
}
