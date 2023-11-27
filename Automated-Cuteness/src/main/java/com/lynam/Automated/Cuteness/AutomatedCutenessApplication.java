package com.lynam.Automated.Cuteness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.lynam.Automated.Cuteness.externalApi")
public class AutomatedCutenessApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomatedCutenessApplication.class, args);
	}

}
