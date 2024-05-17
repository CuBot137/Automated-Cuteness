package com.lynam.Automated.Cuteness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// Allows methods to be run at specific times
@EnableScheduling
@SpringBootApplication
public class AutomatedCutenessApplication {
	public static void main(String[] args) {
		SpringApplication.run(AutomatedCutenessApplication.class, args);
	}
}