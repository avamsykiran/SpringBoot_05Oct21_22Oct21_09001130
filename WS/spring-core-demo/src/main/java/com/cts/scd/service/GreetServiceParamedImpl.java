package com.cts.scd.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("gspi")
public class GreetServiceParamedImpl implements GreetService {
	
	@Value("${greet.note:Hai}")
	private String greetNote;

	@Override
	public String greetUser(String userName) {
		return String.format("%s %s",greetNote,userName);
	}

}
