package com.jklueber.pronounceablegibberish.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ManyGibberish {
    private List<String> gibberishList = new ArrayList<>();
}
