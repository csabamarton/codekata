package com.csmarton.hackerrank.algorithms.leetcode.easy.lengthoflastword;

public class LengthOfLastWord {
    /*
    Given a string s consisting of words and spaces, return the length of the last word in the string.

    A word is a maximal substring consisting of non-space characters only.
     */

    public int solution(String s) {
        s = s.stripTrailing();

        int index = s.length() - 1;
        int lastWordlength = 0;

        while (index >=0) {
            if(s.charAt(index) == ' ')
               return lastWordlength;
            index--;
            lastWordlength++;
        }


        return s.length();
    }
}
