package org.mjmayor.baseproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	
	private static final Logger logger = LoggerFactory.getLogger(AlumnoController.class);	
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String displayAlumnoForm() {
		
		logger.info("UniversidadController - displayAlumnoForm");
		
		return "alumno/form";
	}
}
