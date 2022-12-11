package com.csmarton.hackerrank.algorithms.leetcode.easy.addbinary;

public class AddBinary {
    private static final char ONE = '1';
    private static final char ZERO = '0';

    public String addBinary(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();

        int loopLength = Math.max(lengthA, lengthB);

        StringBuilder sb = new StringBuilder();

        boolean remainder = false;
        if(a.charAt(a.length() - 1) == ONE && b.charAt(b.length() - 1) == ONE) {
            remainder = true;
            sb.append(ZERO);
        } else {
            if (a.charAt(a.length() - 1) != b.charAt(b.length() - 1))
                sb.append(ONE);
            else {
                sb.append(ZERO);
                if (loopLength == 1)
                    return sb.toString();
            }
        }

        for (int i = 1; i < loopLength; i++) {
            char aNum = lengthA - 1 - i >= 0 ? a.charAt(lengthA - 1 - i) : ZERO;
            char bNum = lengthB - 1 - i >= 0 ? b.charAt(lengthB - 1 - i) : ZERO;

            char sumNum;

            if(aNum == ONE && bNum == ONE){
                sumNum = ZERO;
                if(remainder)
                    sumNum = ONE;
                remainder = true;
            } else if (aNum != bNum) {
                if (!remainder) {
                    sumNum = ONE;
                } else {
                    sumNum = ZERO;
                }
            } else {
                sumNum = ZERO;
                if (remainder)
                    sumNum = ONE;
                remainder = false;
            }

            sb.append(sumNum);
        }
        if(remainder)
            sb.append(ONE);

        return sb.reverse().toString();
    }
}
