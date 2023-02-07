package com.csmarton.hackerrank.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class ReverseVowels {
    public String reverseVowels(String s) {
        List<Character> vowels = List.of('a','e','i','o','u', 'A', 'E', 'I', 'O', 'U');
        List<Integer> vowIndexes = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i)))
                vowIndexes.add(i);
        }

        int left = 0;
        int right = vowIndexes.size() - 1;

        StringBuilder sb = new StringBuilder(s);

        while (left < right) {
            char temp = s.charAt(vowIndexes.get(left));
            char r = s.charAt(vowIndexes.get(right));

            sb.setCharAt(vowIndexes.get(left), r);
            sb.setCharAt(vowIndexes.get(right), temp);

            left++;
            right--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseVowels reverseVowels = new ReverseVowels();
        reverseVowels.reverseVowels("hello");
    }
}
