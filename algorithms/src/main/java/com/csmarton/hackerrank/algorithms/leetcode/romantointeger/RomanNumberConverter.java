package com.csmarton.hackerrank.algorithms.leetcode.romantointeger;

public class RomanNumberConverter {

    private enum Roman {
        CM(900),
        CD(400),
        XC(90),
        XL(40),
        IX(9),
        IV(4),
        M(1000),
        D(500),
        C(100),
        L(50),
        X(10),
        V(5),
        I(1);

        public final int value;

        Roman(final int value) {
            this.value = value;
        }
    }

    public int convertRomanToInt(final String s) {
        String input = s;
        int number = 0;

        boolean foundNumner = false;

        while (input.length()>0) {
            foundNumner = false;
            for(Roman value : Roman.values()) {
                if(input.startsWith(value.name())) {
                    input = input.substring(value.name().length());
                    number += value.value;
                    foundNumner = true;
                    break;
                }
            }
            if(!foundNumner)
                throw new IllegalArgumentException(String.format("'%s' contains an invalid roman number!", s));
        }

        return number;
    }
}
