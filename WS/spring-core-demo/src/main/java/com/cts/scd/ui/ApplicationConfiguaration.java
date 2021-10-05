package com.cts.scd.ui;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.cts.scd.service")
@PropertySource("classpath:application.properties")
public class ApplicationConfiguaration {

}
