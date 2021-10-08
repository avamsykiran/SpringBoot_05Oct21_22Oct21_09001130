package com.cts.sbwa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/arth")
public class ArithemticController {

	@GetMapping
	public String showArthPageAction() {
		return "arth-page";
	}
	
	@GetMapping("/sum")	
	public ModelAndView sumAction(@RequestParam("op1")int n1,@RequestParam("op2")int n2) {
		return new ModelAndView("arth-page",
				"msg",String.format("Sum of %d and %d is %d", n1,n2,n1+n2));
	}
	
	@GetMapping("/dif")	
	public ModelAndView difAction(@RequestParam("op1")int n1,@RequestParam("op2")int n2) {
		return new ModelAndView("arth-page",
				"msg",String.format("Difference of %d and %d is %d", n1,n2,n1-n2));
	}
	
	@GetMapping("/prd")	
	public ModelAndView prdAction(@RequestParam("op1")int n1,@RequestParam("op2")int n2) {
		return new ModelAndView("arth-page",
				"msg",String.format("Product of %d and %d is %d", n1,n2,n1*n2));
	}
	
	@GetMapping("/qut")	
	public ModelAndView qutAction(@RequestParam("op1")int n1,@RequestParam("op2")int n2) {
		return new ModelAndView("arth-page",
				"msg",String.format("Quotiont of %d and %d is %d", n1,n2,n1/n2));
	}
}
