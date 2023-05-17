package com.adjecti.oexam.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adjecti.oexam.entity.Role;
import com.adjecti.oexam.entity.User;
import com.adjecti.oexam.repository.UserRepository;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String signin() {
		return "redirect:/user/";
	}

	@RequestMapping(value = "/success")
	public String success(Principal principal) {

		User user = userRepository.findByUserId(principal.getName());

		boolean b = false;
		for (Role r : user.getRoles()) {
			if (r.getRole().equals("ROLE_ADMIN")) {
				b = true;
			} else {
				b = false;
			}
		}

		if (b == true) {
			return "redirect:/admin/";
		} else {
			return "redirect:/user/";
		}
//		return null;

	}

	@RequestMapping("/authFail")
	public String handleError(Model model) {

		model.addAttribute("bad_credential", "Bad Credential");
		return "login";
	}

	@RequestMapping("/accessDenied")
	public String accessDenied(Model model) {

		model.addAttribute("bad_credential", "Bad Credential");
		return "login";
	}
}
