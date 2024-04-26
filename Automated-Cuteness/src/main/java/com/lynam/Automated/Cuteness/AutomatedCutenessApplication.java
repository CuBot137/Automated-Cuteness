package com.lynam.Automated.Cuteness;

import ClickSend.ApiClient;
import lombok.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;

// Allows methods to be run at specific times
@EnableScheduling
@SpringBootApplication
public class AutomatedCutenessApplication {
	private static ApplicationContext applicationContext;
	public static void main(String[] args) {

		applicationContext = SpringApplication.run(AutomatedCutenessApplication.class, args);




	}



}
