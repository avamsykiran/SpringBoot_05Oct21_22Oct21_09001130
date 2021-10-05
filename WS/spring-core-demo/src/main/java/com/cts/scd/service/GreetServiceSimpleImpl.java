package com.cts.scd.service;

import org.springframework.stereotype.Component;

@Component("gssi")
public class GreetServiceSimpleImpl implements GreetService {

	@Override
	public String greetUser(String userName) {
		return String.format("%s %s","Hello",userName);
	}

}
