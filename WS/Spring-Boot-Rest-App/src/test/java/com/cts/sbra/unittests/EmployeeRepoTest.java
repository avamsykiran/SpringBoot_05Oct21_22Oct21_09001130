package com.cts.sbra.unittests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cts.sbra.entity.Employee;
import com.cts.sbra.repo.EmployeeRepo;

@ExtendWith(SpringExtension.class)
@DataJpaTest // h2 database and executes the database schema and enables the sql logs
public class EmployeeRepoTest {

	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	private TestEntityManager testEntityManager; // direct access to the h2 database

	private Employee[] testData;

	public EmployeeRepoTest() {
		this.testData = new Employee[] { new Employee("Vamsy", 45600.0, LocalDate.now(), "vamsy@gmail.com"),
				new Employee("Suseela", 65600.0, LocalDate.now(), "suseela@gmail.com"),
				new Employee("Indhikaa", 85600.0, LocalDate.now(), "indhikaa@gmail.com") };
	}

	@BeforeEach
	void setUp() {
		// load the inital data into the database
		for (int i = 0; i < testData.length; i++)
			testData[i] = testEntityManager.persistAndFlush(testData[i]);
	}

	@AfterEach
	void cleanUp() {
		// reset the databae back to empty to prepare for the next test case
		for (Employee e : testData)
			testEntityManager.remove(e);
		testEntityManager.flush();
	}

	@Test
	void existsByEmailIdTest() {
		assertAll(
			() -> assertThat(empRepo.existsByEmailId(testData[0].getEmailId())).isTrue(),
			() -> assertThat(empRepo.existsByEmailId("random@gmail.com")).isFalse()
		);
	}
	
	@Test
	void findByEmailIdTest() {
		assertAll(
			() -> assertThat(empRepo.findByEmailId(testData[0].getEmailId())).isEqualTo(testData[0]),
			() -> assertThat(empRepo.findByEmailId("random@gmail.com")).isNull()
		);
	}
		
	
}
