package com.csmarton.hackerrank.algorithms.leetcode.easy;

public class MaxNumber {

    public int maximum69Number (int num) {
        String number = String.valueOf(num);

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if(c == '6')
                return (int)(num + 3 * (Math.pow(10, number.length() - i - 1)));
        }

        return num;
    }

    public static void main(String[] args) {
        MaxNumber maxNumber = new MaxNumber();

        int i = maxNumber.maximum69Number(9669);

        System.out.println(i);
    }
}