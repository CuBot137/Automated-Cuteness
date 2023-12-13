package com.lynam.Automated.Cuteness;

import com.lynam.Automated.Cuteness.config.ProjectConfig;
import com.lynam.Automated.Cuteness.controller.QuoteController;
import com.lynam.Automated.Cuteness.service.QuoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


// Allows methods to be run at specific times
@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = {"com.lynam.Automated.Cuteness.config"})
public class AutomatedCutenessApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomatedCutenessApplication.class, args);

		// Messing around with creating beans
//		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
//		QuoteService s = context.getBean(QuoteService.class);
//		System.out.println();

	}

}
