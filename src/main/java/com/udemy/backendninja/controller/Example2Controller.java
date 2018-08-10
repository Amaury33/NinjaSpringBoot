package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {
	
	private final String EXAMPLE2_VIEW = "example2";

	//localhost:8080/example2/request1?name=john
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name="name", required=false, defaultValue="NO_NAME") String name) {
		ModelAndView model = new ModelAndView(EXAMPLE2_VIEW);
		model.addObject("nameModel", name);
		return model;
	}
	
	//localhost:8080/example2/request2/Mike
	@GetMapping(value = "/request2/{name}")
	public ModelAndView request2(@PathVariable("name") String name) {
		ModelAndView model = new ModelAndView(EXAMPLE2_VIEW);
		model.addObject("nameModel", name);
		return model;
	}


}
