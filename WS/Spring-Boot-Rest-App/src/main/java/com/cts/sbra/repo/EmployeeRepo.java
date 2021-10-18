package com.cts.sbra.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.sbra.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	boolean existsByEmailId(String emailId);
	Employee findByEmailId(String emailId);
	
	@Query("SELECT e FROM Employee e WHERE e.fullName LIKE :partialFullName")
	List<Employee> findAllByFullName(String partialFullName);
	
	@Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :lowerLimit AND :upperLimit")
	List<Employee> findAllInSalaryRange(double lowerLimit,double upperLimit);
}
