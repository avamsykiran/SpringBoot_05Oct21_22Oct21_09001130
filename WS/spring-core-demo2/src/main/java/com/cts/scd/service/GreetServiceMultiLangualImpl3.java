package com.cts.scd.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetServiceMultiLangualImpl3 implements GreetService {
	
	@Value("#{${greet.multi.map}}")
	private Map<String,String> greetNotes;

	@Override
	public String greetUser(String userName) {
		
		StringBuffer sb = new StringBuffer();
		for(String key:greetNotes.keySet()) {
			sb.append(String.format("In %s: %s %s\n",key,greetNotes.get(key),userName));
		}
		
		return sb.toString();
	}

}
