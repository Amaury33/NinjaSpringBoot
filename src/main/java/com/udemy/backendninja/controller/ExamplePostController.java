package com.udemy.backendninja.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example3")
public class ExamplePostController {

	private static final Log LOGGER = LogFactory.getLog(ExamplePostController.class);

	private static final String FORM_VIEW = "form";
	private static final String RESULT_VIEW = "result";

	// REDIRECT OPTION 1
	// @GetMapping(value = "/")
	// public String redirect() {
	// return "redirect:/example3/showForm";
	// }

	// REDIRECT OPTION 2
	@GetMapping(value = "/")
	public RedirectView redirect() {
		return new RedirectView("/example3/showForm");
	}

	@GetMapping(value = "/showForm")
	public String showForm(Model model) {
		/*
		 * LOGGER.info("INFO MESSAGE"); LOGGER.warn("WARNING MESSAGE");
		 * LOGGER.error("ERROR MESSAGE"); LOGGER.debug("DEBUG MESSAGE");
		 */
		model.addAttribute("person", new Person());

		// In order to test 500 internal server error
		// int g = 7/0;

		return FORM_VIEW;
	}

	@PostMapping(value = "/addPerson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
		LOGGER.info("METHOD: 'addPerson': " + person);

		ModelAndView model = new ModelAndView(RESULT_VIEW);
		
		if (bindingResult.hasErrors()) {
			model.setViewName(FORM_VIEW);
		} else {
			model.setViewName(RESULT_VIEW);
			model.addObject("person", person);
		}
		
		return model;
	}

}
