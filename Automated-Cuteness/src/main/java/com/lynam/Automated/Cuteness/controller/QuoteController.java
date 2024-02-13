package com.lynam.Automated.Cuteness.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lynam.Automated.Cuteness.externalApi.QuoteApi;
import com.lynam.Automated.Cuteness.service.QuoteService;
import com.lynam.Automated.Cuteness.valentine.Valentine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

@RestController
@Slf4j
public class QuoteController {
    @Autowired
    private QuoteApi quoteApi;

    private final QuoteService quoteService;

    @Autowired
    private Valentine valentine;

    public QuoteController(QuoteApi quoteApi, QuoteService quoteService, Valentine valentine) {
        this.quoteApi = quoteApi;
        this.quoteService = quoteService;
        this.valentine = valentine;
    }

    /**
     * Generates the quote, parses through the java response.
     * @return Formatted quote and author
     * @throws JsonProcessingException
     */
    @GetMapping("/quote")
    public String getQuote() throws JsonProcessingException {
        String apiResponse = quoteApi.callQuoteApi();
        System.out.println(apiResponse);
        if (apiResponse != null) {
            try {
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

    @PostMapping("/poop")
    @Scheduled(cron = "0 0 12 * * ?")
    public String sendTest () throws JsonProcessingException {
        String message = "Diggy Diggy Hole";
        return quoteService.sendSms(message);
    }

    @Scheduled(cron = "0 0 8 * * *")
    @Scheduled(cron = "0 0 10 * * *")
    @Scheduled(cron = "0 0 12 * * *")
    @Scheduled(cron = "0 0 14 * * *")
    @Scheduled(cron = "0 0 21 * * *")
    @PostMapping("/valentine")
    public String diggy() throws IOException {
        String message = valentine.cute();
        System.out.println(message);
        return quoteService.sendSms(message);
    }


    @GetMapping("/main")
    public String mainPage(){
        return "Main.html";
    }




}
