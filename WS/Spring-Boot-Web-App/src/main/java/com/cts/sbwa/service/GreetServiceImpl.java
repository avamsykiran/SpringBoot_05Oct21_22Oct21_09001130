package com.cts.sbwa.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceImpl implements GreetService {

	@Override
	public String greet() {
		String greeting="";
		
		int h = LocalDateTime.now().getHour();
		
		if(h>=3 && h<=11) greeting="Good Morning";
		else if(h>=12 && h<=16) greeting="Good Noon";
		else greeting="Good Evening";
		
		return greeting;
	}

}
