package com.cts.sbra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.sbra.entity.Employee;
import com.cts.sbra.exception.EmployeeException;
import com.cts.sbra.repo.EmployeeRepo;

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

		if (emp != null) {
			if (emp.getEmpId() != null && empRepo.existsById(emp.getEmpId())) {
				throw new EmployeeException("Duplicate empId for employee record");
			}

			if (empRepo.existsByEmailId(emp.getEmailId())) {
				throw new EmployeeException("Duplicate email id for the employee record");
			}

			emp = empRepo.save(emp);

		}

		return emp;
	}

	@Override
	public Employee update(Employee emp) throws EmployeeException {
		if (emp != null) {
			if (emp.getEmpId() == null || !empRepo.existsById(emp.getEmpId())) {
				throw new EmployeeException("Employee not found to update");
			}
			
			Employee temp = empRepo.findByEmailId(emp.getEmailId());
			if(temp!=null && !temp.getEmpId().equals(emp.getEmpId())) {
				throw new EmployeeException("Duplicate email id for the employee record");
			}
			
			emp = empRepo.save(emp);
		}

		return emp;
	}

	@Override
	public void deleteById(Long id) throws EmployeeException {
		if (!empRepo.existsById(id)) {
			throw new EmployeeException("Employee not found to delete");
		} else {
			empRepo.deleteById(id);
		}
	}

	@Override
	public Employee getByEmail(String emailId) {
		return empRepo.findByEmailId(emailId);
	}

	@Override
	public List<Employee> getAllInSalRange(double lb, double ub) {
		return empRepo.findAllInSalaryRange(lb, ub);
	}

	@Override
	public List<Employee> getAllByFullName(String fullName) {
		return empRepo.findAllByFullName("%"+fullName+"%");
	}

}
