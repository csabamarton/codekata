package com.csmarton.hackerrank.algorithms.daily.day1;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Valid Anagram
 * Description:
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */

public class ValidAnagram {
    public boolean solve(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);

            freq.put(t.charAt(i), freq.getOrDefault(t.charAt(i), 0) - 1);

        }

        return freq.values().stream().filter(i -> i != 0).findFirst().isEmpty();
    }
}
