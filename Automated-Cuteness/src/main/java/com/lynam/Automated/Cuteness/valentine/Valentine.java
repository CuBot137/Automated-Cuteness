package com.lynam.Automated.Cuteness.valentine;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Valentine {
    static int lineNumber = 1;
    public String cute() throws IOException {
        InputStream inputStream = new ClassPathResource("static/Input.txt").getInputStream();
//        InputStream inputStream = new FileInputStream("static/Input.txt");
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
//        try {
//            InputStream is = getClass().getResourceAsStream("Automated-Cuteness/Input.txt");
//            InputStreamReader isr = new InputStreamReader(is);
//            BufferedReader br = new BufferedReader(isr);
//            StringBuffer sb = new StringBuffer();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }


//        try {
//            String line = Files.readAllLines(Paths.get("Automated-Cuteness/Input.txt")).get(lineNumber);
//            System.out.println(line);
//            lineNumber++;
//            return line;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

