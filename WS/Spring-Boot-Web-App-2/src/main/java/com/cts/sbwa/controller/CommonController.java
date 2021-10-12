package com.cts.sbwa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	
	@ModelAttribute("title")
	public String title() {
		return "Employee CRUD Demo";
	}
	
	@RequestMapping("/header")
	public String headerAction() {
		return "header-page";
	}
	
	@RequestMapping("/footer")
	public String footerAction() {
		return "footer-page";
	}
}
