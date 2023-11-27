package com.lynam.Automated.Cuteness.controller;

import com.lynam.Automated.Cuteness.externalApi.QuoteApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {

    @Autowired
    private QuoteApi quoteApi;

    @GetMapping("/quote")
    public String getQuote(){
        String apiResponse = quoteApi.callQuoteApi();
        System.out.println(apiResponse);
        return apiResponse;
    }
}
