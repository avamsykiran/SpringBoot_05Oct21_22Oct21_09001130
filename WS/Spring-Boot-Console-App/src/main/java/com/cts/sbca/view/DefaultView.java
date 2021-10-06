package com.cts.sbca.view;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cts.sbca.service.GreetService;

@Component
public class DefaultView {

	@Autowired
	public Scanner kbin;
	
	@Autowired
	@Qualifier("greetServiceSimpleImpl")
	private GreetService greetService1;

	@Autowired
	@Qualifier("greetServiceParamedImpl")
	private GreetService greetService2;
	
	@Autowired
	@Qualifier("greetServiceMultiLangualImpl")
	private GreetService greetService3;
	
	@Autowired
	@Qualifier("greetServiceMultiLangualImpl2")
	private GreetService greetService4;
	
	@Autowired
	@Qualifier("greetServiceMultiLangualImpl3")
	private GreetService greetService5;

	public void show() {
		System.out.println("Application Execution Started!");
		
		System.out.print("User Name?");
		String userName = kbin.nextLine();
		
		System.out.println(greetService1.greetUser(userName));
		System.out.println(greetService2.greetUser(userName));
		System.out.println(greetService3.greetUser(userName));
		System.out.println(greetService4.greetUser(userName));
		System.out.println(greetService5.greetUser(userName));
	}
}
