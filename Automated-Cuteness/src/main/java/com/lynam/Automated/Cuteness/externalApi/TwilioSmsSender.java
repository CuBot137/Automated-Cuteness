package com.lynam.Automated.Cuteness.externalApi;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSmsSender implements SmsSender{

    private final TwilioConfiguration twilioConfiguration;
    @Autowired
    private SmsRequest smsRequest;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration, SmsRequest smsRequest) {
        this.twilioConfiguration = twilioConfiguration;
        this.smsRequest = smsRequest;
    }

    @Override
    public void sendSMS(SmsRequest SmsRequest) {

        if(isPhoneNumberValid(SmsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(SmsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
        }else{
            throw new IllegalArgumentException("Phone number ["+smsRequest.getPhoneNumber()+"] is not a valid number");
        }
    }
    // Add more to this.At the moment it does not validate the number.
    private boolean isPhoneNumberValid(String phoneNumber) {
        return true;
    }
}
