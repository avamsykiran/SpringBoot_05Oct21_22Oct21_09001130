package com.cts.sbra.unittests;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.sbra.SpringBootRestAppApplication;
import com.cts.sbra.entity.Employee;
import com.cts.sbra.repo.EmployeeRepo;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
classes = SpringBootRestAppApplication.class)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
public class EmployeeControllerTest {

	public static final String EMPS_URL = "/emps";
	
	@Autowired
	private MockMvc mvcClient;
	
	@Autowired
	private EmployeeRepo empRepo;
	
	private Employee[] testData;

	public EmployeeControllerTest() {
		this.testData = new Employee[] { new Employee("Vamsy", 45600.0, LocalDate.now(), "vamsy@gmail.com"),
				new Employee("Suseela", 65600.0, LocalDate.now(), "suseela@gmail.com"),
				new Employee("Indhikaa", 85600.0, LocalDate.now(), "indhikaa@gmail.com") };
	}

	@BeforeEach
	void setUp() {
		// load the inital data into the database
		for (int i = 0; i < testData.length; i++)
			testData[i] = empRepo.save(testData[i]);
	}

	@AfterEach
	void cleanUp() {
		// reset the database back to empty to prepare for the next test case
		empRepo.deleteAll();
	}

	@Test
	void getAllActionTest() throws Exception {
		mvcClient.perform(get(EMPS_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()", is(3)));
	}
	
	@Test
	void getByIdActionTest() throws Exception {
		mvcClient.perform(get(EMPS_URL+"/"+testData[0].getEmpId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.emailId", is(testData[0].getEmailId())));
	}
}
