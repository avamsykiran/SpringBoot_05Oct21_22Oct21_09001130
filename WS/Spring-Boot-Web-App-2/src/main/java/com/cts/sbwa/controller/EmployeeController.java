package com.cts.sbwa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbwa.entity.Employee;
import com.cts.sbwa.exception.EmployeeException;
import com.cts.sbwa.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;

	@GetMapping({"","/","/home"})
	public ModelAndView showHomeAction() {
		return new ModelAndView("home-page","emps",empService.getAll());
	}
	
	@GetMapping("/addEmp")
	public ModelAndView showEmployeeFormAction() {
		return new ModelAndView("emp-form-page","emp",new Employee());
	}
	
	@PostMapping("/addEmp")
	public ModelAndView addEmployeeAction(
			@ModelAttribute("emp") @Valid Employee emp,
			BindingResult validationResults) throws EmployeeException {
		ModelAndView mv =null;
		
		if(validationResults.hasErrors()) {
			mv = new ModelAndView("emp-form-page","emp",emp);
		}else {
			empService.add(emp);
			mv = new ModelAndView("redirect:/home");
		}
		
		return mv;
	}
		
	@GetMapping("/editEmp/{eid}")
	public ModelAndView showEmployeeFormAction(@PathVariable("eid") Long empId) throws EmployeeException {
		Employee emp = empService.getById(empId);
		
		if(emp==null)
			throw new EmployeeException("No Such Employee Found To Edit");
		
		return new ModelAndView("emp-form-page","emp",emp);
	}
	
	@PostMapping("/editEmp/{eid}")
	public ModelAndView editEmployeeAction(
			@ModelAttribute("emp") @Valid Employee emp,
			BindingResult validationResults) throws EmployeeException {
		ModelAndView mv =null;
		
		if(validationResults.hasErrors()) {
			mv = new ModelAndView("emp-form-page","emp",emp);
		}else {
			empService.update(emp);
			mv = new ModelAndView("redirect:/home");
		}
		
		return mv;
	}
	
	@GetMapping("/deleteEmp/{eid}")
	public String deleteEmployeeAction(@PathVariable("eid") Long empId) throws EmployeeException {
		
		empService.deleteById(empId);
		
		return "redirect:/home";
	}
}
