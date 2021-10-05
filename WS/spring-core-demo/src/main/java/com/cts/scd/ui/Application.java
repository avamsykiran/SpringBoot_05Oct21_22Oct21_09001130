package com.cts.scd.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.scd.service.GreetService;

public class Application {

	public static void main(String[] args) {
		//GreetService gs = new GreetServiceSimpleImpl();
		//System.out.println(gs.greetUser("Vamsy Kiran"));
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(ApplicationConfiguaration.class);
		
		GreetService gs =(GreetService) context.getBean("gssi");
		System.out.println(gs.greetUser("Vamsy Kiran"));
		
		GreetService gs2 =(GreetService) context.getBean("gspi");
		System.out.println(gs2.greetUser("Vamsy Kiran"));
	}

}
