package com.cts.sbwa.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbwa.exception.EmployeeException;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(EmployeeException.class)
	public ModelAndView handleEmployeeException(EmployeeException exp) {
		exp.printStackTrace();
		return new ModelAndView("error-page","errMsg",exp.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleEmployeeException(Exception exp) {
		exp.printStackTrace();
		return new ModelAndView("error-page","errMsg","Some Internal Server Failure!");
	}
}
