package com.jklueber.pronounceablegibberish.util;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class FileLoader {
    public InputStream getFile(String name) {
        return getClass().getClassLoader().getResourceAsStream(name);
    }

    public List<String> getStringsFromFile(String name) {
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(getFile(name))) {
            while (scanner.hasNext()) {
                result.add(scanner.nextLine());
            }
        }

        return result;
    }
}
