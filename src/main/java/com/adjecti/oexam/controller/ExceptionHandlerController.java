
package com.adjecti.oexam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionHandlerController {
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView internalServerError() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		return mv;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ModelAndView pageNotFound() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		return mv;
	}

	@ExceptionHandler(Forbidden.class)
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	public ModelAndView forbidden() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		return mv;
	}
}
