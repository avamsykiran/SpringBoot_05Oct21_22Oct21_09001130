package com.cts.sbca;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cts.sbca.view.DefaultView;

@SpringBootApplication
public class SpringBootConsoleAppApplication implements CommandLineRunner{

	@Autowired
	private DefaultView view;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootConsoleAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		view.show();
	}

	@Bean
	public Scanner keyboardScanner() {
		return new Scanner(System.in);
	}

}
