package com.cts.sbwa.service;

import java.util.List;

import com.cts.sbwa.exception.EmployeeException;
import com.cts.sbwa.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAll() throws EmployeeException;
	Employee getById(Long id) throws EmployeeException;
	Employee add(Employee emp)  throws EmployeeException;
	Employee update(Employee emp) throws EmployeeException;
	void deleteById(Long id) throws EmployeeException;
}
