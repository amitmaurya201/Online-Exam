package com.adjecti.oexam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.adjecti.oexam.service.ResultService;

@Controller
@RequestMapping("/admin")
public class AdminController {



	// --------------------to display the admin panel page--------------------
	@RequestMapping("/")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminpage");
		return modelAndView;
	}

	// -----------------to display the home page of sdmin-----------------
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminpage");
		return modelAndView;
	}

	// ----------- to logout from admin panel------------------
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutAdmin(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}

}
