package com.csmarton.hackerrank.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> digitsFrequency = new HashMap<>();
        int numOfBulls = 0;
        int numOfCows = 0;


        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);

            if(digitsFrequency.containsKey(c))
                digitsFrequency.put(c, digitsFrequency.get(c) + 1);
            else
                digitsFrequency.put(c, 1);
        }

        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);

            if(digitsFrequency.containsKey(c)) {

                if(secret.charAt(i) == c) {
                    numOfBulls++;
                } else
                    numOfCows++;

                if (digitsFrequency.get(c) <= 0)
                    numOfCows--;
                else
                    digitsFrequency.put(c, digitsFrequency.get(c) - 1);
            }
        }

        return numOfBulls + "A" + numOfCows + "B";
    }

    public String getHint2(String secret, String guess) {
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
