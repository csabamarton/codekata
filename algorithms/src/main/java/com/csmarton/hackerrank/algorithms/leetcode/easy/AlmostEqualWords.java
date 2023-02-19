package com.csmarton.hackerrank.algorithms.leetcode.easy;

public class AlmostEqualWords {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] diff = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            int index = word1.charAt(i) - 'a';
            diff[index]++;
        }

        for (int i = 0; i < word1.length(); i++) {
            int index = word2.charAt(i) - 'a';
            diff[index]--;
        }

        for (int i = 0; i < diff.length; i++) {
            if(Math.abs(diff[i]) > 3)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        AlmostEqualWords almostEqualWords = new AlmostEqualWords();

        boolean result = almostEqualWords.checkAlmostEquivalent("abcdeef", "abaaacc");

        System.out.println(result);
    }
}
