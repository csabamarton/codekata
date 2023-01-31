package com.csmarton.hackerrank.algorithms.leetcode.easy;

public class MostFreqChar {
    public char findMostFrequentChar(String s) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        int index = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 26; i++) {
            if ( arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }

        return (char)('a' + index);
    }
}
