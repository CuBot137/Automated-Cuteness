package com.lynam.Automated.Cuteness.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lynam.Automated.Cuteness.externalApi.QuoteApi;
import com.lynam.Automated.Cuteness.externalApi.SmsRequest;
import com.lynam.Automated.Cuteness.externalApi.TwilioApi;
import com.lynam.Automated.Cuteness.service.QuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class QuoteController {

    @Autowired
    private QuoteApi quoteApi;

    @Autowired
    private TwilioApi twilioApi;
    @Autowired
    private QuoteService quoteService;


    @Autowired
    public QuoteController(QuoteApi quoteApi, TwilioApi twilioApi, QuoteService quoteService) {
        this.quoteApi = quoteApi;
        this.twilioApi = twilioApi;
        this.quoteService = quoteService;
    }

    @GetMapping("/quote")
    public String getQuote() throws JsonProcessingException {
        String apiResponse = quoteApi.callQuoteApi();
        System.out.println(apiResponse);

        ObjectMapper mapper = new ObjectMapper();
//      JsonNode jsonNode = mapper.readTree(apiResponse);
        String quote = mapper.readTree(apiResponse).findValue("content").asText();
        String author = mapper.readTree(apiResponse).findValue("author").asText();
        return "Quote: " + quote +" Author: "+author;
    }


    @PostMapping("sms")
    public String sendSms (@RequestBody SmsRequest smsRequest){
        log.info("sms Started sendRequest: "+smsRequest.toString());

        return quoteService.sendSms(smsRequest.getDestinationSmsNumber(), smsRequest.getSmsMessage());

    }
}
