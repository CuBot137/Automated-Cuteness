package com.lynam.Automated.Cuteness.externalApi;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class QuoteApi {


    // An api I found on GitHub that generates a random quote
    public String callQuoteApi(){
        String uri = "https://api.quotable.io/random";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return result;
    }
}
