package com.cts.sbra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.sbra.exception.EmployeeException;

@RestControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<String> handleEmployeeException(EmployeeException exp) {
		exp.printStackTrace();
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleEmployeeException(Exception exp) {
		exp.printStackTrace();
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
