package com.cts.scd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.scd.service.Counter;
import com.cts.scd.view.DefaultView;

public class Appliction {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(ApplicationConfiguaration.class);
		
		DefaultView view =  (DefaultView) context.getBean("defaultView");
		view.show();
		
		Counter c1 = (Counter) context.getBean("counter");
		System.out.println(c1.getCount());
		Counter c2 = (Counter) context.getBean("counter");
		System.out.println(c2.getCount());
		Counter c3 = (Counter) context.getBean("counter");
		System.out.println(c3.getCount());
		Counter c4 = (Counter) context.getBean("counter");
		System.out.println(c4.getCount());
	}

}
