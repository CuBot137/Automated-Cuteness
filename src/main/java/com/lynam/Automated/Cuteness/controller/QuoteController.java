package com.lynam.Automated.Cuteness.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lynam.Automated.Cuteness.email.EmailDetails;
import com.lynam.Automated.Cuteness.email.EmailService;
import com.lynam.Automated.Cuteness.externalApi.QuoteApi;
import com.lynam.Automated.Cuteness.service.QuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private EmailService emailService;
    @Autowired
    private QuoteService quoteService;
//    @Value("${USER_NAME}")
    private String email = "conorlynam1234@gmail.com";

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
    @PostMapping("/sendMail")
    public String
    sendMail(@RequestBody EmailDetails details) {
        String status = emailService.sendSimpleMail(details);
        return status;
    }
    @PostMapping("/mailQuote")
    public String sendMail() throws JsonProcessingException {
        String quote = getQuote();
        EmailDetails emailDetails = new EmailDetails(email,quote,"Email Service");
        return emailService.sendSimpleMail(emailDetails);
    }
}