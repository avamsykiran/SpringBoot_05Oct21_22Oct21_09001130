package com.cts.scd.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class GreetServiceMultiLangualImpl implements GreetService {
	
	@Value("${greet.multi}")
	private String[] greetNotes;

	@Override
	public String greetUser(String userName) {
		
		StringBuffer sb = new StringBuffer();
		for(String greetNote:greetNotes) {
			sb.append(String.format("%s %s\n",greetNote,userName));
		}
		
		return sb.toString();
	}

}
