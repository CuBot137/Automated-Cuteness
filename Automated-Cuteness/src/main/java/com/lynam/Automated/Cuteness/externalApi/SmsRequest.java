package com.lynam.Automated.Cuteness.externalApi;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class SmsRequest {
    private String destinationSmsNumber;
//    private String smsMessage;
    @Override
    public String toString() {
        return "SmsRequest{" +
                "destinationSmsNumber='" + destinationSmsNumber + '\'' +
                '}';
    }
}
