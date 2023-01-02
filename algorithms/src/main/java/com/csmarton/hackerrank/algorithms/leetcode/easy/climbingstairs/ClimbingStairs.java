package com.csmarton.hackerrank.algorithms.leetcode.easy.climbingstairs;

public class ClimbingStairs {

    public int climbStairs2(int n) {
        if (n < 4)
            return n;

        int sum = 0, f1 = 2, f2 = 3;

        for (int i = 3; i < n ; i++) {
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }

        return sum;
    }

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
