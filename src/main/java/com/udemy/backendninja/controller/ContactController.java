package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.backendninja.constant.ViewConstant;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	@GetMapping("/contactForm")
	public String redirectContactForm() {
		return ViewConstant.CONTACT_FORM;
	}

}
