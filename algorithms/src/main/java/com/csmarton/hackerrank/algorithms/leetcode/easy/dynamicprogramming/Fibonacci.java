package com.csmarton.hackerrank.algorithms.leetcode.easy.dynamicprogramming;

public class Fibonacci {
    public int fib(int n) {
        if (n == 0 || n == 1)
            return n;

        int f1 = 0, f2 = 1, sum = 0;

        for (int i = 1; i < n ; i++) {
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }

        return sum;
    }

    private int recursion(int n) {
        if(n == 0 || n == 1)
            return n;
        return recursion(n - 1) + recursion(n - 2);
    }
}
