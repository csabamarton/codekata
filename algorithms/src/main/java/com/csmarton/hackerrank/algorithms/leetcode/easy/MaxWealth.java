package com.csmarton.hackerrank.algorithms.leetcode.easy;

import java.util.stream.IntStream;

public class MaxWealth {

    public int maximumWealth(int[][] accounts) {
        int[] sums = new int[accounts.length];

        for (int personIndex = 0; personIndex < accounts.length; personIndex++) {
            for (int bankIndex = 0; bankIndex < accounts[0].length; bankIndex++) {
                sums[personIndex] += accounts[personIndex][bankIndex];
            }
        }

        return IntStream.range(0, sums.length).map(i -> sums[i]).max().getAsInt();
    }
}
