package com.lynam.Automated.Cuteness.controller;

import ClickSend.Api.SmsApi;
import ClickSend.ApiClient;
import ClickSend.ApiException;
import ClickSend.Model.SmsMessage;
import ClickSend.Model.SmsMessageCollection;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lynam.Automated.Cuteness.clicksend.MessageDetails;
import com.lynam.Automated.Cuteness.externalApi.QuoteApi;
import com.lynam.Automated.Cuteness.service.QuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class QuoteController {
    @Autowired
    private ApiClient clickSendConfig;
    @Autowired
    private QuoteApi quoteApi;

    private final QuoteService quoteService;

    public QuoteController(QuoteApi quoteApi, QuoteService quoteService) {
        this.quoteApi = quoteApi;
        this.quoteService = quoteService;
    }

    @GetMapping("/quote")
    public String getQuote() throws JsonProcessingException {
        String apiResponse = quoteApi.callQuoteApi();
        System.out.println(apiResponse);
        if (apiResponse != null) {
            try {
                // Json deserialization
                ObjectMapper mapper = new ObjectMapper();
                String quote = mapper.readTree(apiResponse).findValue("content").asText();
                String author = mapper.readTree(apiResponse).findValue("author").asText();
                // Save quote and author to database
                quoteService.saveQuote(quote, author);
                return "Quote: " + quote + " Author: " + author;
            } catch (Exception e) {
                System.out.println("Oops there was an error! " + e);
                return "Oops, there was an error processing the quote.";
            }
        } else {
            throw new NullPointerException("API response is null");
        }
    }

    // cron will run this method every day at 12 noon
    @PostMapping("/sms")
    @Scheduled(cron = "0 0 12 * * ?")
    public String sendSms () throws JsonProcessingException {
            String message = getQuote();
            return quoteService.sendSms(message);
    }



    @PostMapping("/sms1000")
    public ResponseEntity<String> sendSMStoUpto1000Numbers(@RequestBody MessageDetails messageDetails) {
        SmsApi smsApi = new SmsApi(clickSendConfig);

        SmsMessage smsMessage = new SmsMessage();
        smsMessage.body(messageDetails.getMessageBody());
        smsMessage.listId(messageDetails.getListId());
        smsMessage.source(messageDetails.getSendingSource());

        List<SmsMessage> smsMessageList = List.of(smsMessage);

        // SmsMessageCollection | SmsMessageCollection model
        SmsMessageCollection smsMessages = new SmsMessageCollection();
        smsMessages.messages(smsMessageList);

        try {
            String result = smsApi.smsSendPost(smsMessages);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (ApiException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Exception when calling SmsApi#smsSendPost", HttpStatus.BAD_REQUEST);
    }

}
