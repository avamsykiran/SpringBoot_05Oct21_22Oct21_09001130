package com.cts.sbra.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
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
	private Long empId;
	
	@NotBlank(message = "Full Name is a mandate field")
	@Size(min = 5,max = 50,message = "Full Name is expected to be 5 to 50 chars in length")
	@Column(name="fnm",nullable = false)
	private String fullName;
	
	@NotNull(message="Salary is a mandate field")
	@Min(value = 5000,message="Salary must be atlest 5000")
	@Max(value = 500000,message="Salary must be atmax 500000")
	@Column(name="sal",nullable = false)
	private Double salary;
	
	@NotNull(message="Join Date is a mandate field")
	@DateTimeFormat(iso = ISO.DATE)
	@PastOrPresent(message="Join Date can not be a future date")
	@Column(name="jdt",nullable = false)
	private LocalDate joinDate;
	
	@Email(message="Expecting a vl;aid email id")
	@Column(name="email",nullable = true,unique = true)
	private String emailId;
	
	public Employee() {}
	
	public Employee(
			@NotBlank(message = "Full Name is a mandate field") @Size(min = 5, max = 50, message = "Full Name is expected to be 5 to 50 chars in length") String fullName,
			@NotNull(message = "Salary is a mandate field") @Min(value = 5000, message = "Salary must be atlest 5000") @Max(value = 500000, message = "Salary must be atmax 500000") Double salary,
			@NotNull(message = "Join Date is a mandate field") @PastOrPresent(message = "Join Date can not be a future date") LocalDate joinDate,
			@Email(message = "Expecting a vl;aid email id") String emailId) {
		super();
		this.fullName = fullName;
		this.salary = salary;
		this.joinDate = joinDate;
		this.emailId = emailId;
	}

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((joinDate == null) ? 0 : joinDate.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (joinDate == null) {
			if (other.joinDate != null)
				return false;
		} else if (!joinDate.equals(other.joinDate))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}
	
	
}
