package com.lynam.Automated.Cuteness.valentine;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Valentine {
    static int lineNumber = 1;
    public String cute() throws IOException {
        // Reads from the file
        InputStream inputStream = new ClassPathResource("static/Input.txt").getInputStream();
        // Reads from the input stream
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))){
            int currentLineNumber = 0;
            String line;
            while ((line = br.readLine()) != null) {
                currentLineNumber++;
                if (currentLineNumber == lineNumber) {
                    System.out.println(line);
                    lineNumber++;
                    return line;
                }
            }
            return line;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
