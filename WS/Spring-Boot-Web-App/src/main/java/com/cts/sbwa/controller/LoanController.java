package com.cts.sbwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbwa.model.Loan;
import com.cts.sbwa.service.LoanService;

@Controller
@RequestMapping("/loan")
public class LoanController {

	@Autowired	
	private LoanService loanService;
	
	@GetMapping
	public ModelAndView loanAction() {
		return new ModelAndView("loan-page","loan",new Loan());
	}
	
	@PostMapping
	public ModelAndView loanAction(@ModelAttribute("loan")Loan loan) {
		loanService.computeEMI(loan);
		return new ModelAndView("loan-page","loan",loan);
	}
}
