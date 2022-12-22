package com.csmarton.hackerrank.algorithms.leetcode.easy.countods;

public class CountOds {
    public int countOdds(int low, int high) {
        int gap = (high - low + 1);
        if (gap % 2 == 0 || low % 2 == 0)
            return gap / 2;
        else return gap / 2 + 1;
    }
}
