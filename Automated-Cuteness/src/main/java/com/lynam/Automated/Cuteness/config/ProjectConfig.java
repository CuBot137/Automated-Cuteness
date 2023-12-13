package com.lynam.Automated.Cuteness.config;

import com.lynam.Automated.Cuteness.service.QuoteService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {


    @Bean
    QuoteService quoteService(){
        var s = new QuoteService();
        return s;
    }

    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    Integer ten() {
        return 10;
    }

    @Value("${Twilio_SID}")
    private String ACCOUNT_SID;

    // This is an environment variable that was turned into a bean
    @Bean
    public String twilioBean(){
        return new String(ACCOUNT_SID);
    }

}
