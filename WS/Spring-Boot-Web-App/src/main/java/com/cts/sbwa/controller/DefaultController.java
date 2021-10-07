package com.cts.sbwa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

	@RequestMapping({ "", "/", "/home" })
	public ModelAndView defaultRequestHandler() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("home-page");
		mv.addObject("welcomeMsg", "Hello! Welcome all to my first web applcition on spring boot web");

		return mv;
	}

	@RequestMapping("/header")
	public ModelAndView headerAction() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("header-page");
		mv.addObject("title", "My First Spring Web App");

		return mv;
	}

	@RequestMapping("/footer")
	public String footerAction() {
		return "footer-page";
	}
}
