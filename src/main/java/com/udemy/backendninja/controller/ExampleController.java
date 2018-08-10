package com.udemy.backendninja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.component.ExampleComponent;
import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;

@Controller
@RequestMapping("/Example")
public class ExampleController {

	//This is a test class in order to prove how Spring returns a view. 
	
	private static final String EXAMPLE_VIEW = "Example";
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;

	//First way to return a view.
	@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	public String exampleString(Model model) {
		exampleComponent.sayHello();
		//model.addAttribute("person", new Person("Mike", 22));
		model.addAttribute("people", exampleService.getListPeople());
		return EXAMPLE_VIEW;
	}
	
	//Second way to return a view.	
	@GetMapping("/exampleModelAndView")
	public ModelAndView exampleModelAndView() {
		ModelAndView model = new ModelAndView(EXAMPLE_VIEW);
		//model.addObject("person", new Person("Peter", 45));
		model.addObject("people", exampleService.getListPeople());
		return model;
	}
	
	
	
	
	
}
