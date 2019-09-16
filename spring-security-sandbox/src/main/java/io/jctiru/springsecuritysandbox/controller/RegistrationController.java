package io.jctiru.springsecuritysandbox.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.jctiru.springsecuritysandbox.entity.User;
import io.jctiru.springsecuritysandbox.service.UserService;
import io.jctiru.springsecuritysandbox.user.CrmUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private UserService userService;

	private Logger logger = Logger.getLogger(getClass().getName());

	@GetMapping("/registration-form")
	public String showMyLoginPage(Model model) {
		model.addAttribute("crmUser", new CrmUser());

		return "registration-form";
	}

	@PostMapping("/registration-form")
	public String processRegistrationForm(
			@Valid @ModelAttribute("crmUser") CrmUser crmUser,
			BindingResult bindingResult,
			Model model) {

		String userName = crmUser.getUserName();
		logger.info("Processing registration form for: " + userName);

		// Form validation
		if (bindingResult.hasErrors()) {
			return "registration-form";
		}

		// Check the database if user already exists
		User existingUser = userService.findByUserName(userName);
		if (existingUser != null) {
			model.addAttribute("registrationError", "User name already exists.");
			logger.warning("User name already exists.");

			return "registration-form";
		}

		// Create user account
		userService.save(crmUser);

		logger.info("Successfully created user: " + userName);

		return "registration-confirmation";
	}

}
