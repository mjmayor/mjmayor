package org.mjmayor.baseproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/asignatura")
public class AsignaturaController {
	
	private static final Logger logger = LoggerFactory.getLogger(AsignaturaController.class);	
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String displayAsignaturaForm() {
		
		logger.info("UniversidadController - displayAsignaturaForm");
		
		return "asignatura/form";
	}
}
