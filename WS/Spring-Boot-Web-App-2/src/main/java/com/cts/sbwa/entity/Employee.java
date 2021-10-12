package com.cts.sbwa.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
@Table(name="emps")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name="eid")
	public Long empId;
	
	@NotBlank(message = "Full Name is a mandate field")
	@Size(min = 5,max = 50,message = "Full Name is expected to be 5 to 50 chars in length")
	@Column(name="fnm",nullable = false)
	public String fullName;
	
	@NotNull(message="Salary is a mandate field")
	@Min(value = 5000,message="Salary must be atlest 5000")
	@Max(value = 500000,message="Salary must be atmax 500000")
	@Column(name="sal",nullable = false)
	public Double salary;
	
	@NotNull(message="Join Date is a mandate field")
	@DateTimeFormat(iso = ISO.DATE)
	@PastOrPresent(message="Join Date can not be a future date")
	@Column(name="jdt",nullable = false)
	public LocalDate joinDate;
	
	public Employee() {}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	
	
}
