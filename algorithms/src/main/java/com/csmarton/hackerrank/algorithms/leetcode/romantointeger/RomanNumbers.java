package com.csmarton.hackerrank.algorithms.leetcode.romantointeger;

import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {

    static Map<String, Integer> digitMap = new HashMap<>() {{
        put("M", 1000);
        put("D", 500);
        put("C", 100);
        put("L", 50);
        put("X", 10);
        put("V", 5);
        put("I", 1);
    }};

    static Map<String, Integer> changerNumbersMap = new HashMap<>() {{
        put("CM", 900);
        put("CD", 400);
        put("XC", 90);
        put("XL", 40);
        put("IX", 9);
        put("IV", 4);
    }};

    public int convertRomanToInt(String input) {
        int number = 0;
        int firstIndex = 0;

        while (firstIndex <= input.length()) {
            if(firstIndex == input.length() - 1) {
                return number + digitMap.get(Character.toString(input.charAt(firstIndex)));
            } else {
                String firstTwo = input.substring(firstIndex, firstIndex + 2);
                if (changerNumbersMap.containsKey(firstTwo)) {
                    number = number + changerNumbersMap.get(firstTwo);
                    firstIndex = firstIndex + 2;
                    if(firstIndex >= input.length())
                        return number;
                } else {
                    number = number + digitMap.get(Character.toString(input.charAt(firstIndex)));
                    firstIndex++;
                }
            }
        }

        return number;
    }
}
