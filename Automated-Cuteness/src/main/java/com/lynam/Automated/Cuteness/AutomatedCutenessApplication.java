package com.lynam.Automated.Cuteness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.lynam.Automated.Cuteness.externalApi")
// Allows methods to be run at specific times
@EnableScheduling
public class AutomatedCutenessApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomatedCutenessApplication.class, args);
	}

}
