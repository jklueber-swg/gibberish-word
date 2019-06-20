package com.jklueber.pronounceablegibberish.util;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Component
public class FileLoader {
    public File getFile(String name) {
        return  new File(
                getClass().getClassLoader().getResource(name).getFile()
        );
    }

    public List<String> getStringsFromFile(String name) {
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(getFile(name))) {
            while (scanner.hasNext()) {
                result.add(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }

        return result;
    }
}
