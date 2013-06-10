package org.mjmayor.baseproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/profesor")
public class ProfesorController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProfesorController.class);	
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String displayProfesorForm() {
		
		logger.info("UniversidadController - displayProfesorForm");
		
		return "profesor/form";
	}
}
