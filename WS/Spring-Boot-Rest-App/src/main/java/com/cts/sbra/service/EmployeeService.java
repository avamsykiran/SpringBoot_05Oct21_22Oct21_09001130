package com.cts.sbra.service;

import java.util.List;

import com.cts.sbra.entity.Employee;
import com.cts.sbra.exception.EmployeeException;

public interface EmployeeService {
	
	List<Employee> getAll();
	Employee getById(Long id);
	Employee add(Employee emp)  throws EmployeeException;
	Employee update(Employee emp) throws EmployeeException;
	void deleteById(Long id) throws EmployeeException;
}
