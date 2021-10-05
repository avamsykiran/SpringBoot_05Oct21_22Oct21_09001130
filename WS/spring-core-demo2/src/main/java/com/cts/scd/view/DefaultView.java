package com.cts.scd.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.scd.service.GreetService;

@Component
public class DefaultView {
	
	@Autowired
	private GreetService greetService;

	public void show() {
		System.out.println("Application Execution Started!");
		System.out.println(greetService.greetUser("Vamsy"));
	}
}
