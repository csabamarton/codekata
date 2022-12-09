package com.csmarton.hackerrank.algorithms.leetcode.easy.palindrome;


public class PalindromeNumber {
    public boolean isPalindrome(final int input) {
        if(input < 0)
            return false;

        String inputValue = Integer.toString(input);

        if (inputValue.length() == 1)
            return true;

        int numOfLoops = inputValue.length() / 2;

        for (int i = 0; i < numOfLoops; i++) {
            if(inputValue.charAt(i) != inputValue.charAt(inputValue.length() - 1 - i))
                return false;
        }

        return true;
    }
}
