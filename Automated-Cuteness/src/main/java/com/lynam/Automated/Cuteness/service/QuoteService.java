package com.lynam.Automated.Cuteness.service;

import com.lynam.Automated.Cuteness.externalApi.SmsRequest;
import com.lynam.Automated.Cuteness.externalApi.SmsSender;
import com.lynam.Automated.Cuteness.externalApi.TwilioSmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

    private final SmsSender SmsSender;

    @Autowired
    public QuoteService(@Qualifier("twilio") TwilioSmsSender twilioSmsSender) {
        this.SmsSender = twilioSmsSender;
    }


    public void sendSms(SmsRequest smsRequest){
        SmsSender.sendSMS(smsRequest);
    }
}
