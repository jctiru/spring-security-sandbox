package io.jctiru.springsecuritysandbox.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.jctiru.springsecuritysandbox.service.UserService;
import io.jctiru.springsecuritysandbox.user.CrmUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private UserService userService;

	private Logger logger = Logger.getLogger(getClass().getName());

	@GetMapping("/show-form")
	public String showMyLoginPage(Model model) {
		model.addAttribute("crmUser", new CrmUser());

		return "registration-form";
	}

}
