package com.lynam.Automated.Cuteness.externalApi;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class QuoteApi {
    // An api I found on GitHub that generates a random quote
    public String callQuoteApi(){
        String uri = "https://api.quotable.io/random";
        RestTemplate restTemplate = new RestTemplate();
        // Making a get request to the API
        String result = restTemplate.getForObject(uri, String.class);
        if (result != null) {
            return result;
        } else {
            throw new RuntimeException("API response is null");
        }
    }
}
