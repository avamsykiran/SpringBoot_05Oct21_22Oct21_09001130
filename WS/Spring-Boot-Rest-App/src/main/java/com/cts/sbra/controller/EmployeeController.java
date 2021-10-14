package com.cts.sbra.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.sbra.entity.Employee;
import com.cts.sbra.exception.EmployeeException;
import com.cts.sbra.service.EmployeeService;

@RestController
@RequestMapping("/emps")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllAction() {
		return new ResponseEntity<>(empService.getAll(),HttpStatus.OK);
	}

	@GetMapping("/{eid}")
	public ResponseEntity<Employee> getByIdAction(@PathVariable("eid")Long empId) {
		
		Employee emp = empService.getById(empId);
		
		if(emp==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Employee> addEmployeeAction(
			@RequestBody @Valid Employee emp,
			BindingResult validationResults) throws EmployeeException {
		
		if(validationResults.hasErrors()) {
			String errMsg = validationResults.getAllErrors().
				stream().
				map(err -> err.getDefaultMessage()).
				reduce((m1,m2) -> String.format("%s\n%s", m1,m2)).
				orElse(null);
			throw new EmployeeException(errMsg);
		}
			
		emp = empService.add(emp);
		
		return new ResponseEntity<>(emp,HttpStatus.CREATED);
	}
		
	@PutMapping
	public ResponseEntity<Employee> updateEmployeeAction(
			@RequestBody @Valid Employee emp,
			BindingResult validationResults) throws EmployeeException {
		
		if(validationResults.hasErrors()) {
			String errMsg = validationResults.getAllErrors().
				stream().
				map(err -> err.getDefaultMessage()).
				reduce((m1,m2) -> String.format("%s\n%s", m1,m2)).
				orElse(null);
			throw new EmployeeException(errMsg);
		}
			
		emp = empService.update(emp);
		
		return new ResponseEntity<>(emp,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{eid}")
	public ResponseEntity<Void> deleteEmployeeAction(@PathVariable("eid") Long empId) throws EmployeeException {
		empService.deleteById(empId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
