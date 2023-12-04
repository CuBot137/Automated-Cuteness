package com.lynam.Automated.Cuteness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// Allows methods to be run at specific times
@EnableScheduling
@PropertySource("classpath:application.properties")
public class AutomatedCutenessApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomatedCutenessApplication.class, args);
	}

}
