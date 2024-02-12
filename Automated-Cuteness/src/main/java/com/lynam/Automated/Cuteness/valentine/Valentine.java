package com.lynam.Automated.Cuteness.valentine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Valentine {
    static int lineNumber = 0   ;
    public String cute() {
        try {
            String line = Files.readAllLines(Paths.get("Automated-Cuteness/Input.txt")).get(lineNumber);
            System.out.println(line);
            lineNumber++;
            return line;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
