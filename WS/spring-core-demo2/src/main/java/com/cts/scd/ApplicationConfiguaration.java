package com.cts.scd;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.cts.scd")
@PropertySource("classpath:application.properties")
public class ApplicationConfiguaration {
	
	@Bean
	public Scanner keyboardScanner() {
		return new Scanner(System.in);
	}

}
