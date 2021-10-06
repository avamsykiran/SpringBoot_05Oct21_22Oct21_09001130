package com.cts.scd.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Counter {

	private int count;
	
	public int getCount() {
		return ++count;
	}
}
