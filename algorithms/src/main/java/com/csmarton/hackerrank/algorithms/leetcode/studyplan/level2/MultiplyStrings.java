package com.csmarton.hackerrank.algorithms.leetcode.studyplan.level2;

import java.util.Arrays;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if(num1.length() < num2.length())
        {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int size = num2.length() + num1.length();
        int bigger = Math.max(num1.length(), num2.length());
        int[][] arr = new int[bigger + 1][size];

        int arrRow = 0;
        int arrCol = size - 1;
        int remain = 0;

        for (int i = num1.length() - 1; i >= 0; i--) {
            arrCol = size - 1 - (num1.length() - 1 -i);
            for (int j = num2.length() - 1; j >= 0; j--) {
                int m = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + remain;

                arr[arrRow][arrCol] = m % 10;
                remain = m / 10;
                arrCol--;
            }

            if(remain != 0)
                arr[arrRow][arrCol] = remain;
            remain = 0;

            arrRow++;
        }

        for (int i = size - 1 ; i >= 0 ; i--) {
            int sum = 0;
            for (int j = 0; j < bigger ; j++) {
                sum += arr[j][i];
            }
            arr[arrRow][i] = (sum + remain) % 10;
            remain = (sum + remain) / 10;
        }

        int index = 1;
        if(arr[arrRow][0] != 0) {
            index = 0;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = index; i < arr[0].length; i++) {
            sb.append(arr[arrRow][i]);
        }

        if(sb.indexOf("0") == 0)
            return "0";
        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();

        //multiplyStrings.multiply("2", "3");
        multiplyStrings.multiply("9133", "0");
    }
}
