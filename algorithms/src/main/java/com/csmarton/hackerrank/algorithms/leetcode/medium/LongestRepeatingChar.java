package com.csmarton.hackerrank.algorithms.leetcode.medium;

import java.util.*;

public class LongestRepeatingChar {

    public int characterReplacementWithArray(String s, int k) {
        int maxFrequency = 0;
        int windowSize = 0;
        int start = 0;
        int longestRepeatition = 0;

        int[] frequency = new int[26];

        for (int end = 0; end < s.length(); end += 1) {
            frequency[s.charAt(end) - 'A']++;

            maxFrequency = Arrays.stream(frequency).max().getAsInt();

            boolean validWindow = end - start + 1 - maxFrequency <= k;
            if (!validWindow) {
                frequency[s.charAt(start) - 'A']--;
                start++;
            } else {
                windowSize = end + 1 - start;
                if (windowSize > longestRepeatition)
                    longestRepeatition = windowSize;
            }
        }

        return  longestRepeatition;
    }

    public int characterReplacementWithHashmap(String s, int k) {
        int maxFrequency = 0;
        int windowSize = 0;
        int start = 0;
        int longestRepeatition = 0;

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (int end = 0; end < s.length(); end += 1) {
            char c = s.charAt(end);
            if (frequencyMap.containsKey(c)) {
                frequencyMap.put(c, frequencyMap.get(c) + 1);
            } else
                frequencyMap.put(c, 1);

            maxFrequency = frequencyMap.entrySet().stream().max((Comparator.comparing(Map.Entry::getValue))).get().getValue();

            boolean validWindow = end - start + 1 - maxFrequency <= k;
            if (!validWindow) {
                c = s.charAt(start);
                if (frequencyMap.get(c) == 1)
                    frequencyMap.remove(c);
                else
                    frequencyMap.put(c, frequencyMap.get(c) - 1);
                start++;
            } else {
                windowSize = end + 1 - start;
                if (windowSize > longestRepeatition)
                    longestRepeatition = windowSize;
            }
        }

        return  longestRepeatition;
    }
}
