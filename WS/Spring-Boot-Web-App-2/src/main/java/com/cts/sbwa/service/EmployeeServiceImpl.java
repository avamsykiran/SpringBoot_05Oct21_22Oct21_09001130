package com.cts.sbwa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.sbwa.entity.Employee;
import com.cts.sbwa.exception.EmployeeException;
import com.cts.sbwa.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public List<Employee> getAll() {
		return empRepo.findAll();
	}

	@Override
	public Employee getById(Long id) {
		return empRepo.findById(id).orElse(null);
	}

	@Override
	public Employee add(Employee emp) throws EmployeeException {
		
		if(emp!=null) {
			if(emp.getEmpId()!=null && empRepo.existsById(emp.getEmpId())) {
				throw new EmployeeException("Duplicate employee record");
			}else {
				emp=empRepo.save(emp);		
			}
		}
		
		return emp;
	}

	@Override
	public Employee update(Employee emp) throws EmployeeException {
		if(emp!=null) {
			if(emp.getEmpId()==null || !empRepo.existsById(emp.getEmpId())) {
				throw new EmployeeException("Employee not found to update");
			}else {
				emp=empRepo.save(emp);		
			}
		}
		
		return emp;	
	}

	@Override
	public void deleById(Long id) throws EmployeeException {
		if(!empRepo.existsById(id)) {
			throw new EmployeeException("Employee not found to delete");
		}else {
			empRepo.deleteById(id);
		}
	}

}
