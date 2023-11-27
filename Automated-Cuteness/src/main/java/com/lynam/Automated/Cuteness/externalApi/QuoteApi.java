package com.lynam.Automated.Cuteness.externalApi;


import org.springframework.web.client.RestTemplate;

public class QuoteApi {

    public String callQuoteApi(){
        String uri = "https://api.quotable.io/random";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }
}
