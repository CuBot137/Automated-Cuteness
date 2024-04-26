package com.lynam.Automated.Cuteness.service;

import ClickSend.ApiClient;
import com.lynam.Automated.Cuteness.model.TheModel;
import com.lynam.Automated.Cuteness.repo.TheRepo;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.sql.SQLException;


@Slf4j
@Service
public class QuoteService {
    @Autowired
    private TheRepo repo;
    @Value("${Twilio_SID}")
    private String twilioBean;
    @Value("${Twilio_Auth}")
    String AUTH_TOKEN;
    @Value("${TWILIO_NUMBER}")
    String OUTGOING_SMSNUMBER;
    @Value("${My_Number}")
    String SENDER_NUMBER;

    // When the app is built it will log this information
    public QuoteService(){
        log.info("Creating class QuoteService");
    }
    // Twilio will be initialised after the program starts up

    // Runs this method after the constructor is finished
    @PostConstruct
    private void setup(){
        Twilio.init(twilioBean, AUTH_TOKEN);
    }

    public String sendSms (String smsMessage){
        Message message = Message.creator(
                new PhoneNumber(SENDER_NUMBER),
                new PhoneNumber(OUTGOING_SMSNUMBER),
                smsMessage).create();
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



    @Value("${USER_NAME}")
    private String clickSendUsername;
    @Value("${API_KEY}")
    private String clickSendApiKey;
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ApiClient clickSendConfig() {
        ApiClient clickSendApiClient = new ApiClient();
        clickSendApiClient.setUsername(clickSendUsername);
        clickSendApiClient.setPassword(clickSendApiKey);
        return clickSendApiClient;
    }
}