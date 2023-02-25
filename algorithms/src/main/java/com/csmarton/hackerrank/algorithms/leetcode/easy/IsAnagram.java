package com.csmarton.hackerrank.algorithms.leetcode.easy;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://leetcode.com/problems/valid-anagram/description/
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> freq = s.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));

        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            Integer f = freq.get(c);

            if(f == null) return false;

            if(f == 1){
                freq.remove(c);
            } else freq.put(c, --f);
        }

        return freq.isEmpty();
    }
}
