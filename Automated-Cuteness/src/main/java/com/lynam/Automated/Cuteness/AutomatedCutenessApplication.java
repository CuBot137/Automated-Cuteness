package com.lynam.Automated.Cuteness;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;


// Allows methods to be run at specific times
@EnableScheduling
@SpringBootApplication
public class AutomatedCutenessApplication {
	private static ApplicationContext applicationContext;
	public static void main(String[] args) {

		applicationContext = SpringApplication.run(AutomatedCutenessApplication.class, args);
//		displayAppBeans();
	}

//	public static void displayAppBeans(){
//		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
//		for(String beanName : allBeanNames){
//			System.out.println(beanName);
//		}
//	}

}
