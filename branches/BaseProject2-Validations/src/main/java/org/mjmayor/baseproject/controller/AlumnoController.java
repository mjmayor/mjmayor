package org.mjmayor.baseproject.controller;

import javax.validation.Valid;

import org.mjmayor.baseproject.form.AlumnoForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	
	private static final Logger logger = LoggerFactory.getLogger(AlumnoController.class);	
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String showAlumnoForm(ModelMap model) {
		
		logger.info("AlumnoController - showAlumnoForm");
		
		model.addAttribute("alumnoForm",new AlumnoForm());
		return "alumno/insert";
	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertAlumno(@Valid AlumnoForm alumnoForm, BindingResult result) {
		
		logger.info("AlumnoController - insertAlumno");
		
		if (result.hasErrors()) return "alumno/insert";
		else return "ok";
	}
}
