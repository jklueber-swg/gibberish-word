package com.jklueber.pronounceablegibberish;

import com.jklueber.pronounceablegibberish.util.RandomDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PronounceableGibberishApplication {
    @Autowired
    RandomDictionary dict;

    public static void main(String[] args) {
        SpringApplication.run(PronounceableGibberishApplication.class, args);
    }

}
