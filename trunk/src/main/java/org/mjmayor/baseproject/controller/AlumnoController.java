package org.mjmayor.baseproject.controller;

import javax.validation.Valid;

import org.mjmayor.baseproject.dto.AlumnoDTO;
import org.mjmayor.baseproject.facade.AlumnoFacade;
import org.mjmayor.baseproject.form.AlumnoForm;
import org.mjmayor.baseproject.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(Constants.Alumno.PATH)
public class AlumnoController {

    private static final Logger logger = LoggerFactory.getLogger(AsignaturaController.class);

    private AlumnoFacade alumnoFacade;

    @RequestMapping(value = Constants.INSERT, method = RequestMethod.GET)
    public String showAlumnoForm(ModelMap model) {

	logger.info("AlumnoController - showAlumnoForm");

	model.addAttribute("alumno", new AlumnoDTO());
	return Constants.Alumno.FORM;
    }

    @RequestMapping(value = Constants.INSERT, method = RequestMethod.POST)
    public String insertAlumno(@Valid AlumnoForm alumnoForm, BindingResult result) {

	logger.info("AlumnoController - insertAlumno");

	if (result.hasErrors())
	    return Constants.Alumno.FORM;
	else {
	    alumnoFacade.addAlumno(alumnoForm);
	    return Constants.Alumno.INSERTOK;
	}
    }

    @RequestMapping(value = Constants.DELETE, method = RequestMethod.POST)
    public String deleteAlumno(AlumnoForm alumnoForm) {

	logger.info("AlumnoController - deleteAlumno");

	alumnoFacade.removeAlumno(alumnoForm);
	return Constants.Alumno.DELETEOK;
    }

    @RequestMapping(value = Constants.GET, method = RequestMethod.POST)
    public ModelAndView getAlumno(ModelMap model, AlumnoForm alumnoForm) {

	logger.info("AlumnoController - getAlumno");

	model.addAttribute(Constants.Alumno.ALUMNO_DATA, alumnoFacade.getAlumno(alumnoForm));
	return new ModelAndView(Constants.Alumno.DATA, Constants.MODEL, model);
    }

    @RequestMapping(value = Constants.GETALL, method = RequestMethod.POST)
    public ModelAndView getAllAlumnos(ModelMap model) {

	logger.info("AlumnoController - getAllAlumnos");

	model.addAttribute(Constants.Alumno.ALUMNOS_LIST_DATA, alumnoFacade.getAlumnos());
	return new ModelAndView(Constants.Alumno.LIST, Constants.MODEL, model);
    }
}
