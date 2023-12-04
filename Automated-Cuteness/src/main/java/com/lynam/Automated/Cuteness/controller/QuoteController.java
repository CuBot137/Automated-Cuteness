package com.lynam.Automated.Cuteness.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lynam.Automated.Cuteness.externalApi.QuoteApi;
import com.lynam.Automated.Cuteness.service.QuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class QuoteController {

    @Autowired
    private QuoteApi quoteApi;
    @Autowired
    private QuoteService quoteService;


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



    // cron will run this method every day at 12 noon
    @PostMapping("/sms")
    @Scheduled(cron = "0 0 12 * * ?")
    public String sendSms () throws JsonProcessingException {
            String message = getQuote();
            return quoteService.sendSms(message);
    }
}
