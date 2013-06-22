package org.mjmayor.baseproject.controller;

import javax.validation.Valid;

import org.mjmayor.baseproject.form.ProfesorForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {

    private static final Logger logger = LoggerFactory.getLogger(ProfesorController.class);

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String displayProfesorForm(ModelMap model) {

	logger.info("ProfesorController - displayProfesorForm");

	model.addAttribute("profesorForm", new ProfesorForm());
	return "profesor/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertProfesor(@Valid ProfesorForm profesorForm, BindingResult result) {

	logger.info("ProfesorController - insertProfesor");

	if (result.hasErrors())
	    return "profesor/insert";
	else
	    return "ok";
    }
}
