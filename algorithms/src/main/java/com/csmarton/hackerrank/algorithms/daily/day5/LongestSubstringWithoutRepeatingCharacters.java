package com.csmarton.hackerrank.algorithms.daily.day5;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        HashMap<Character, Integer> pos = new HashMap<>();

        int start = 0;
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer last = pos.get(c);

            if (last != null) {
                if(last < start) {
                    pos.put(c, i);

                    if (max < i - start);
                        max = i - start;
                }
            }
            if (pos.containsKey(c)) {
                if(pos.get(c) > start)
                    start =
                start = pos.get(c) + 1;
            } else {
                pos.put(c, i);
            }


        }
        return max;
    }
}
