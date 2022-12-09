package com.csmarton.hackerrank.algorithms.leetcode.easy.longestcommonprefix;

public class LongestCommonPrefix {

    /*
    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".
     */

    public String longestCommonPrefix(String[] input) {
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i <input.length; i++) {
            if (input[i].length() < shortest)
                shortest = input[i].length();
        }

        if(shortest == 0) return "";

        boolean canLoop = true;
        int index = 0;
        while (canLoop) {
            String firstWord = input[0];
            char letter = firstWord.charAt(index);
            for (int i = 1; i < input.length; i++) {
                if (input[i].charAt(index) != letter) {
                    return input[0].substring(0, index);
                }
            }
            index++;
            if(index == shortest)
                return input[0].substring(0, index);
        }

        return "This never ends here";
    }
}
