package com.lynam.Automated.Cuteness.service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QuoteService {

//    private final SmsSender SmsSender;
//
//    @Autowired
//    public QuoteService(@Qualifier("twilio") TwilioSmsSender twilioSmsSender) {
//        this.SmsSender = twilioSmsSender;
//    }

    // Values are in application.properties
    @Value("${TWILIO_ACCOUNT_SID}")
    String ACCOUNT_SID;
    @Value("${TWILIO_AUTH_TOKEN}")
    String AUTH_TOKEN;
    @Value("${TWILIO_OUTGOING_SMSNUMBER}")
    String OUTGOING_SMSNUMBER;
    @Value("${TWILIO_SENDER_NUMBER}")
    String SENDER_NUMBER;


    public QuoteService(){
        log.info("Creating class QuoteService");
    }

    // When the app is built it will log this information
    @PostConstruct
    private void setup(){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }


    public String sendSms (String smsMessage){
        Message message = Message.creator(
                new PhoneNumber(SENDER_NUMBER),
                new PhoneNumber(OUTGOING_SMSNUMBER),
                smsMessage).create();
        return message.getStatus().toString();
    }
}
