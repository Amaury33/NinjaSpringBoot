package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.backendninja.model.UserCredential;

@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);

	@GetMapping("/")
	public String redirectToLogin() {
		LOG.info("METHOD: redirectToLogin");
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		LOG.info("METHOD: showLoginForm() -- PARAMS: error=" + error + " , logout=" + logout);
		model.addAttribute("userCredentials", new UserCredential());
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		LOG.info("Return to login page.");

		return "login";
	}

	@PostMapping("/loginCheck")
	public String loginCheck(@ModelAttribute(name = "userCredentials") UserCredential userCredential) {
		LOG.info("METHOD: loginCheck() -- PARAMS: userCredential=" + userCredential.toString());
		if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
			LOG.info("Return to contacts page.");
			return "contacts";
		}

		LOG.info("Return to login page (error).");
		return "redirect:/login?error";
	}

}
