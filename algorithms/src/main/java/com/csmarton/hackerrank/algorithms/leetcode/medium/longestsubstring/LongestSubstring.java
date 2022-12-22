package com.csmarton.hackerrank.algorithms.leetcode.medium.longestsubstring;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;

        Map<Character, Integer> charPositions = new HashMap<>();

        int longest = 0, startIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            if(charPositions.containsKey(s.charAt(i)) && charPositions.get(s.charAt(i)) >= startIndex)
                startIndex = charPositions.get(s.charAt(i)) + 1;

            charPositions.put(s.charAt(i), i);

            if(i - startIndex + 1 > longest)
                longest = i - startIndex + 1;
        }

        return longest;
    }
}
