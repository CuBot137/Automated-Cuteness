package com.lynam.Automated.Cuteness.config;

import com.lynam.Automated.Cuteness.valentine.Valentine;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = "com/lynam/Automated/Cuteness")
public class ProjectConfig {


    // Creating instance of valentine. Each autowired instance of valentine will hold this instance
    @Bean
    public Valentine valentine(){
        return new Valentine();
    }
}