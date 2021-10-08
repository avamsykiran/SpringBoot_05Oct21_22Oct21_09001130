package com.cts.sbwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbwa.service.GreetService;

@Controller
public class GreetController {

	@Autowired
	private GreetService greetService;
	
	@GetMapping("/greet")
	public ModelAndView greetAction(@RequestParam(name="unm",required = false) String userName) {
		ModelAndView mv = new ModelAndView("greet-page");
		
		if(userName!=null) {
			mv.addObject("msg",String.format("%s %s", greetService.greet(),userName));
		}
		
		return mv;
	}
}
