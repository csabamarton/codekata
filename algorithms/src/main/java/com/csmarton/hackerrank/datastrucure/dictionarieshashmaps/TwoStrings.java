package com.csmarton.hackerrank.datastrucure.dictionarieshashmaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoStrings {

    /**
     * Given two string the method gives back a boolean. It will be true if there is a substring which exists in both of the strings
     * @param firstText First text for match
     * @param secondText Second text for match
     * @return true/false result of substring search
     */
    public String solution(String firstText, String secondText) {

        Map<String, Boolean> firstStringLetters = new HashMap<>();
        Arrays.stream(firstText.split("")).forEach(letter -> firstStringLetters.put(letter, null));

        for (String letter : secondText.split("")) {
            if(firstStringLetters.containsKey(letter)) {
                return "YES";
            }
        }

        return "NO";
    }
}
