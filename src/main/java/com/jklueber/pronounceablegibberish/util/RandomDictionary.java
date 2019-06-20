package com.jklueber.pronounceablegibberish.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Data
public class RandomDictionary {
    private List<String> vowels;
    private List<String> consonants;
    private List<String> words;
    private Random rng = new Random();
    private boolean initialized = false;

    @Autowired
    FileLoader files;

    private void initialize() {
        if (!initialized) {
            vowels = files.getStringsFromFile("vowels.txt");
            consonants = files.getStringsFromFile("consonants.txt");
            words = files.getStringsFromFile("words_alpha.txt");
            initialized = true;
        }
    }

    public String makeRandomWord(int minLen) {
        initialize();

        List<List<String>> src = new ArrayList<>();

        src.add(vowels);
        src.add(consonants);

        StringBuffer word = new StringBuffer();
        boolean vowelOrConsonant = rng.nextBoolean();

        while(word.length() < minLen) {
            List<String> choose;
            if (vowelOrConsonant) {
                choose = src.get(0);
            } else {
                choose = src.get(1);
            }
            vowelOrConsonant = !vowelOrConsonant;

            word.append(choose.get(rng.nextInt(choose.size())));
        }

        return word.toString();
    }

    public String makeRandomGibberishWord(int minLen) {
        initialize();
        String candidate = null;

        while(candidate == null || words.contains(candidate)) {
            candidate = makeRandomWord(minLen);
        }

        return candidate;
    }

}
