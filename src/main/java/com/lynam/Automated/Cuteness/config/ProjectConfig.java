package com.lynam.Automated.Cuteness.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import java.util.Properties;

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = "com/lynam/Automated/Cuteness")
public class ProjectConfig {

    @Value("${USER_NAME}")
    private String name;
    @Value("${APP_PASS}")
    private String password;
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587); // or 465 for SSL

        mailSender.setUsername(name);
        mailSender.setPassword(password); // Use app-specific password

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
    @Bean
    public SimpleMailMessage emailTemplate()
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(name);
        message.setFrom(name);
        message.setText("FATAL - Application crash!");
        return message;
    }
}
