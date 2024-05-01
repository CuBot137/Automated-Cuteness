package com.lynam.Automated.Cuteness.email;

import org.springframework.stereotype.Component;

@Component
public interface EmailService {
    String sendSimpleMail(EmailDetails details);
}
