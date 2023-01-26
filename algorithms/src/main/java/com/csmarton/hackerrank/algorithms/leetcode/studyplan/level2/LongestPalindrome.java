package com.csmarton.hackerrank.algorithms.leetcode.studyplan.level2;

import java.util.*;

public class LongestPalindrome {

    public int longestPalindrome(String[] words) {
        Map<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            } else
                frequency.put(word, 1);
        }

        int numOfLetters = 0;

        boolean hadOddTwins = false;

        for (String key : frequency.keySet()) {
            if(frequency.get(key) < 1) continue;

            String reverse = "" + key.charAt(1) + key.charAt(0);

            if (key.equals(reverse)) {
                if (frequency.get(key) % 2 == 0) {
                    numOfLetters += 2 * frequency.get(key);
                    frequency.put(key, 0);
                    continue;
                }

                if(!hadOddTwins) {
                    hadOddTwins = true;
                    numOfLetters += 2 * frequency.get(key);
                } else {
                    numOfLetters += 2 * frequency.get(key) - 2;
                }
                continue;
            }

            Integer revFreq = frequency.get(reverse);
            Integer freq = frequency.get(key);

            if (frequency.containsKey(reverse) && revFreq > 0) {

                int min = Math.min(revFreq, freq);
                frequency.put(reverse, revFreq - min);
                frequency.put(key, freq - min);

                numOfLetters += min * 4;
            }
        }

        return numOfLetters;
    }


}
