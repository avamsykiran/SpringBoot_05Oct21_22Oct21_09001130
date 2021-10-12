package com.cts.sbwa.service;

import java.util.List;

import com.cts.sbwa.entity.Employee;
import com.cts.sbwa.exception.EmployeeException;

public interface EmployeeService {
	
	List<Employee> getAll();
	Employee getById(Long id);
	Employee add(Employee emp)  throws EmployeeException;
	Employee update(Employee emp) throws EmployeeException;
	void deleById(Long id) throws EmployeeException;
}
