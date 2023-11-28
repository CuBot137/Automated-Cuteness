package com.lynam.Automated.Cuteness.externalApi;

import com.twilio.Twilio;
import com.twilio.rest.conversations.v1.conversation.Message;
import com.twilio.rest.messaging.v1.service.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TwilioApi {



//    private final static Logger logger = LoggerFactory.getLogger(TwilioApi.class);
//
//    public final TwilioConfiguration twilioConfiguration;
//
//    @Autowired
//    public TwilioApi(TwilioConfiguration twilioConfiguration) {
//        this.twilioConfiguration = twilioConfiguration;
//        Twilio.init(
//                twilioConfiguration.getAccountSid(),
//                twilioConfiguration.getAuthToken()
//        );
//        logger.info("Twilio initialized... with sid "+twilioConfiguration.getAccountSid());
//    }

//    public void twilioApiCall(String message1) {
//        String TWILIO_API_ACCOUNT_SID = "SK5f98fc89a254ef850d855a92807d14d5";
//        String TWILIO_API_AUTH_TOKEN = "e9f8079764fce77a4650dd52389586dc";
//
////        Twilio.init(TWILIO_API_ACCOUNT_SID, TWILIO_API_AUTH_TOKEN);
//
//
//        Message message = Message.creator(
//                String.valueOf(new phoneNumber("whatsapp:+3530862428967"))
//        ).create();
//    }
}
