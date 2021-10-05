package com.cts.scd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.scd.view.DefaultView;

public class Appliction {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(ApplicationConfiguaration.class);
		
		DefaultView view =  (DefaultView) context.getBean("defaultView");
		view.show();
	}

}
