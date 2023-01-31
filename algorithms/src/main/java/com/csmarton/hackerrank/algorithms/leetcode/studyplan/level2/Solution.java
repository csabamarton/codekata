package com.csmarton.hackerrank.algorithms.leetcode.studyplan.level2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    char isValid(String s, String t) {

        int[] sArr = new int[26];
        int[] tArr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            sArr[c - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            tArr[c - 'a']++;
        }

        for (int i = 0; i < sArr.length; i++) {
            if(sArr[i] != tArr[i])
                return (char)(i + 'a');
        }

        return 'a';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char valid = solution.isValid("abcd", "ceadb");
        System.out.println(valid);
    }
}
