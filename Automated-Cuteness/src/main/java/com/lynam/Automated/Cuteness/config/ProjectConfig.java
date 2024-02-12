package com.lynam.Automated.Cuteness.config;

import com.lynam.Automated.Cuteness.valentine.Valentine;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.bind.Nested;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = "com/lynam/Automated/Cuteness")
public class ProjectConfig {


    @Bean
    public Valentine valentine(){
        return new Valentine();
    }
}
