package com.lynam.Automated.Cuteness.service;


import com.lynam.Automated.Cuteness.model.TheModel;
import com.lynam.Automated.Cuteness.repo.TheRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
@Slf4j
@Service
public class QuoteService {
    @Autowired
    private TheRepo repo;
    public String saveQuote(String quote, String author) throws SQLException {
        TheModel theModel = new TheModel();
        theModel.setQuote(quote);
        theModel.setAuthor(author);
        repo.save(theModel);
        if(theModel.getId() != null){
            System.out.println("Model has been saved to the database!");
            return theModel.toString();
        }
        else{
            throw new SQLException("Model failed to save to database!");
        }
    }
}