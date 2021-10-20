package com.cts.sbwa.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.sbwa.exception.EmployeeException;
import com.cts.sbwa.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${rest.endpoint.emps}")
	private String empsEndPoint;
	
	@Override
	public List<Employee> getAll() throws EmployeeException {
		//return restTemplate.getForObject(empsEndPoint,Employee[].class);
		
		ResponseEntity<Employee[]> resp= restTemplate.getForEntity(empsEndPoint, Employee[].class);
		
		if(resp.getStatusCode()!=HttpStatus.OK)
			throw new EmployeeException("Coudl not contact resource server");
		
		return Arrays.asList(resp.getBody());
	}

	@Override
	public Employee getById(Long id) throws EmployeeException{
		ResponseEntity<Employee> resp= restTemplate.getForEntity(empsEndPoint+"/"+id, Employee.class);

		if(resp.getStatusCode()==HttpStatus.NOT_FOUND)
			return null;
		
		if(resp.getStatusCode()!=HttpStatus.OK)
			throw new EmployeeException("Could not contact resource server");
		
		return resp.getBody();
	}

	@Override
	public Employee add(Employee emp) throws EmployeeException {
		
		if(emp!=null) {
			ResponseEntity<Employee> resp= restTemplate.postForEntity(empsEndPoint, emp, Employee.class);
			
			if(resp.getStatusCode()!=HttpStatus.CREATED)
				throw new EmployeeException("Could not contact resource server");
			
			emp=resp.getBody();
		}
		
		return emp;
	}

	@Override
	public Employee update(Employee emp) throws EmployeeException {
		if(emp!=null) {
			restTemplate.put(empsEndPoint, emp);
		}
		
		return emp;	
	}

	@Override
	public void deleteById(Long id) throws EmployeeException {
		restTemplate.delete(empsEndPoint+"/"+id);
	}

}
