package com.cts.sbwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbwa.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;

	@GetMapping({"","/","/home"})
	public ModelAndView showHomeAction() {
		return new ModelAndView("home-page","emps",empService.getAll());
	}
		
}
