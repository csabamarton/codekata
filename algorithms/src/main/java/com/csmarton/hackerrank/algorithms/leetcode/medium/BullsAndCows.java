package com.csmarton.hackerrank.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        StringBuilder sbSecret = new StringBuilder(secret);

        int numOfBulls = 0;
        int numOfCows = 0;
        Map<Integer, Integer> digitsPosition = new HashMap<>();

        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (sbSecret.charAt(i) == c) {
                numOfBulls++;
                sbSecret.setCharAt(i, 'X');
                continue;
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            if(sbSecret.charAt(i) == 'X')
                continue;
            char c = guess.charAt(i);
            int from = 0;

            if(digitsPosition.containsKey((int) c)) {
                from = digitsPosition.get((int) c) + 1;
            }

            int indexOf = sbSecret.indexOf(String.valueOf(c), from);

            if(indexOf > -1) {
                digitsPosition.put((int) c, indexOf);

                numOfCows++;
            }
        }

        return numOfBulls + "A" + numOfCows + "B";
    }
}
