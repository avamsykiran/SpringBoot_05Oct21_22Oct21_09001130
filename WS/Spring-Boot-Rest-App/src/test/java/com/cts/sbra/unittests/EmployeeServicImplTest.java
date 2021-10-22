package com.cts.sbra.unittests;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cts.sbra.entity.Employee;
import com.cts.sbra.repo.EmployeeRepo;
import com.cts.sbra.service.EmployeeService;
import com.cts.sbra.service.EmployeeServiceImpl;

@ExtendWith(SpringExtension.class)
public class EmployeeServicImplTest {

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean
		public EmployeeService employeeService() {
			return new EmployeeServiceImpl();
		}
	}

	@MockBean
	private EmployeeRepo empRepo;

	@Autowired
	private EmployeeService empService;
	
	private Employee[] testData;

	public EmployeeServicImplTest() {
		this.testData = new Employee[] { new Employee("Vamsy", 45600.0, LocalDate.now(), "vamsy@gmail.com"),
				new Employee("Suseela", 65600.0, LocalDate.now(), "suseela@gmail.com"),
				new Employee("Indhikaa", 85600.0, LocalDate.now(), "indhikaa@gmail.com") };
	}

	@Test
	void getAllTest() {
		List<Employee> emps = Arrays.asList(testData);
		Mockito.when(empRepo.findAll()).thenReturn(emps);
		assertThat(empService.getAll()).isEqualTo(emps);
	}
}
