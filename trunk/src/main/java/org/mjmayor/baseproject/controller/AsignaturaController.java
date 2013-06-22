package org.mjmayor.baseproject.controller;

import javax.validation.Valid;

import org.mjmayor.baseproject.form.AsignaturaForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/asignatura")
public class AsignaturaController {

    private static final Logger logger = LoggerFactory.getLogger(AsignaturaController.class);

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String showAsignaturaForm(ModelMap model) {

	logger.info("AsignaturaController - showAsignaturaForm");

	model.addAttribute("asignaturaForm", new AsignaturaForm());
	return "asignatura/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertAsignatura(@Valid AsignaturaForm asignaturaForm, BindingResult result, ModelMap model) {

	logger.info("AsignaturaController - insertAsignatura");

	if (result.hasErrors())
	    return "asignatura/insert";
	else
	    return "ok";
    }
}
