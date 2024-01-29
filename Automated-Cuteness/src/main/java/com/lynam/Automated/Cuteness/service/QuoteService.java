package com.lynam.Automated.Cuteness.service;

import com.lynam.Automated.Cuteness.model.TheModel;
import com.lynam.Automated.Cuteness.repo.TheRepo;
import com.lynam.Automated.Cuteness.twilio.TwilioSID;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;


@Slf4j
@Service
public class QuoteService {
    @Autowired
    private TheRepo repo;
    private final TwilioSID twilioSID = new TwilioSID();
    String twilioBean = twilioSID.getSIDTwilio();
    String AUTH_TOKEN = twilioSID.getAuth();
    String OUTGOING_SMSNUMBER = twilioSID.getOutgoingNumber();
    String SENDER_NUMBER = twilioSID.getNumber();

    // When the app is built it will log this information
    public QuoteService(){
        log.info("Creating class QuoteService");
    }
    // Twilio will be initialised after the program starts up
    @PostConstruct
    private void setup(){
        Twilio.init(twilioBean, AUTH_TOKEN);
    }
    public String sendSms (String smsMessage){
        Message message = Message.creator(
                new PhoneNumber(SENDER_NUMBER),
                new PhoneNumber(OUTGOING_SMSNUMBER),
                smsMessage).create();
        //System.out.println("THIS IS THE VALUE OF TWILIOBEAN "+twilioBean);
        return message.getStatus().toString();
    }

    public String saveQuote(String quote, String author) throws SQLException {
        TheModel theModel = new TheModel();
        theModel.setQuote(quote);
        theModel.setAuthor(author);
        repo.save(theModel);
        if(theModel.getId() != null){
            System.out.println("Model has been saved to the database!");
            return theModel.toString();
        }
        else{
            throw new SQLException("Model failed to save to database!");
        }
    }
}
