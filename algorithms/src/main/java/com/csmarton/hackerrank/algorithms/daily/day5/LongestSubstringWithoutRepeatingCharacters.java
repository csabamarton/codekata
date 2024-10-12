package com.csmarton.hackerrank.algorithms.daily.day5;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2)
            return s.length();

        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);

        int start = 0;
        int max = 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer pos = map.get(c);

            if (pos != null && pos >= start) {
                start = pos + 1;
            }
            int length = i - start + 1;
            if (max < length)
                max = length;
            map.put(c, i);
        }

        return max;
    }
}
