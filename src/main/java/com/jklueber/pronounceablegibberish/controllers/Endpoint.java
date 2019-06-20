package com.jklueber.pronounceablegibberish.controllers;

import com.jklueber.pronounceablegibberish.model.DebugResponse;
import com.jklueber.pronounceablegibberish.model.GibberishResponse;
import com.jklueber.pronounceablegibberish.util.RandomDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Endpoint {
    @Autowired
    RandomDictionary dict;

    @GetMapping("/length/{len}")
    public GibberishResponse getGibberish(@PathVariable int len) {
        GibberishResponse resp = new GibberishResponse();
        resp.setGibberish(dict.makeRandomGibberishWord(len));
        return resp;
    }

    @GetMapping()
    public GibberishResponse getGibberishDefault() {
        return getGibberish(8);
    }

    @GetMapping("/debug")
    public DebugResponse getDebug() {
        DebugResponse debug = new DebugResponse();
        StringBuffer info = new StringBuffer();

        info.append("Vowels: ").append(dict.getVowels().size()).append("\n");
        info.append("Consonants: ").append(dict.getConsonants().size()).append("\n");
        info.append("Words: ").append(dict.getWords().size()).append("\n");

        debug.setDebugInfo(info.toString());
        return debug;
    }

}
