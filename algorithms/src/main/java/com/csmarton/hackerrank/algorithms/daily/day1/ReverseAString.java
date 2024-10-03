package com.csmarton.hackerrank.algorithms.daily.day1;

public class ReverseAString {

    public char[] solve(char[] chars) {
        if (chars.length == 1)
            return chars;

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return chars;
    }
}
