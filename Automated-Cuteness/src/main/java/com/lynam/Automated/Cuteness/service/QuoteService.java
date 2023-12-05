package com.lynam.Automated.Cuteness.service;

import com.lynam.Automated.Cuteness.repo.TheRepo;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class QuoteService {


    // Values are in application.properties
    @Value("${Twilio_SID}")
    String ACCOUNT_SID;
    @Value("${Twilio_Auth}")
    String AUTH_TOKEN;
    @Value("${TWILIO_OUTGOING_SMSNUMBER}")
    String OUTGOING_SMSNUMBER;
    @Value("${My_Number}")
    String SENDER_NUMBER;


    // When the app is built it will log this information
    public QuoteService(){
        log.info("Creating class QuoteService");
    }


    // Twilio will be initialised after the program starts up
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
