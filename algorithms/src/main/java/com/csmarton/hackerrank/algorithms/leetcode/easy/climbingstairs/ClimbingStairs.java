package com.csmarton.hackerrank.algorithms.leetcode.easy.climbingstairs;

public class ClimbingStairs {

    public int climbingStairs(int n) {
        n++;
        int n0 = 0, n1 = 1;
        int tempNthTerm;
        for (int i = 2; i <= n; i++) {
            tempNthTerm = n0 + n1;
            n0 = n1;
            n1 = tempNthTerm;
        }
        return n1;
    }

}
