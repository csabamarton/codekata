package com.csmarton.hackerrank.algorithms.leetcode.easy.palindrome;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.



Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (charMap.containsKey(key))
                charMap.put(key, charMap.get(key) + 1);
            else charMap.put(key, 1);
        }

        int longestPalindrome = 0;

        boolean hasOdd = false;

        for (Integer value : charMap.values()) {
            if (!hasOdd)
                if (value % 2 != 0)
                    hasOdd = true;
            longestPalindrome += value / 2;
            List.of()
        }

        return hasOdd ? (longestPalindrome * 2 + 1) : longestPalindrome * 2;
    }
}
