package com.lynam.Automated.Cuteness.externalApi;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class SmsRequest {
    // Model for sending message. Message content is handled by QuoteAPI
    private String destinationSmsNumber;

    @Override
    public String toString() {
        return "SmsRequest{" +
                "destinationSmsNumber='" + destinationSmsNumber + '\'' +
                '}';
    }
}
