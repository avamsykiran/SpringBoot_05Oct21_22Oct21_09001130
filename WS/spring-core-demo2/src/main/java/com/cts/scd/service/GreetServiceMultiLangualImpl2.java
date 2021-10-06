package com.cts.scd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetServiceMultiLangualImpl2 implements GreetService {
	
	@Value("#{${greet.multi.list}}")
	private List<String> greetNotes;

	@Override
	public String greetUser(String userName) {
		
		StringBuffer sb = new StringBuffer();
		for(String greetNote:greetNotes) {
			sb.append(String.format("%s %s\n",greetNote,userName));
		}
		
		return sb.toString();
	}

}
