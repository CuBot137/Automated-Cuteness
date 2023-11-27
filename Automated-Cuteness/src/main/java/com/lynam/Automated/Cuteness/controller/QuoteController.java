package com.lynam.Automated.Cuteness.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lynam.Automated.Cuteness.externalApi.QuoteApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {

    @Autowired
    private QuoteApi quoteApi;

    @GetMapping("/quote")
    public String getQuote() throws JsonProcessingException {
        String apiResponse = quoteApi.callQuoteApi();
        System.out.println(apiResponse);

        ObjectMapper mapper = new ObjectMapper();
//        JsonNode jsonNode = mapper.readTree(apiResponse);
        return mapper.readTree(apiResponse).findValue("content").asText();
    }
}
