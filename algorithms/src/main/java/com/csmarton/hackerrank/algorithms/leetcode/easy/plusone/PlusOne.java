package com.csmarton.hackerrank.algorithms.leetcode.easy.plusone;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class PlusOne {

    public int[] plusOne2(int[] digits) {
        boolean hasNonNines = false;
        int length = digits.length;
        for (int digit : digits) {
            if (digit != 9) {
                hasNonNines = true;
                break;
            }
        }

        if (!hasNonNines) {
            int[] result = new int[length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = 0;
            }
            return result;
        }

        boolean remainer = false;
        if(digits[length - 1] == 9){
            remainer = true;
            digits[length - 1] = 0;
        } else{
            digits[length - 1] = digits[length - 1] + 1;
        }

        for (int i = length - 2; i >= 0 ; i--) {
            int num = digits[i];

            if(remainer) {
                if (num == 9) {
                    digits[i] = 0;
                } else {
                    digits[i] = digits[i] + 1;
                    break;
                }
            } else {
                break;
            }

        }
        return digits;
    }

    public int[] plusOne(int[] digits) {
        double number = convertDigitsToInt(digits);
        return convertIntegerToDigits(number + 1);
    }

    public int[] convertIntegerToDigits(double value) {
        String s = new BigDecimal(value, new MathContext(0, RoundingMode.DOWN)).toPlainString();

        return s.chars().map(c -> c - '0').toArray();
    }

    public double convertDigitsToInt(int[] digits) {
        double number = 0;
        for (int i = digits.length - 1; i >= 0 ; i--) {
            int index = digits.length - i - 1;
            double pow =  Math.pow(10, index);
            number += digits[i] * pow;
        }

        return number;
    }
}
