package com.csmarton.hackerrank.algorithms.daily.day5;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int prepre = 1;
        int pre = 2;

        int total;

        for (int i = 3; i <= n; i++) {
            total = pre + prepre;
            prepre = pre;
            pre = total;
        }

        return pre;

    }
}
