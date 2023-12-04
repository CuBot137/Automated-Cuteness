package com.lynam.Automated.Cuteness.externalApi;

import org.springframework.stereotype.Component;

@Component
public interface SmsSender {
    default void sendSMS(SmsRequest SmsRequest){

    }
}
