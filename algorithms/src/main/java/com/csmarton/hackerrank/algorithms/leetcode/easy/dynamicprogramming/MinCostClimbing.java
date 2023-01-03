package com.csmarton.hackerrank.algorithms.leetcode.easy.dynamicprogramming;

public class MinCostClimbing {

    public int minCostClimbingStairs(int[] cost) {
        int minCost = 0;

        int i = 0;

        while (i < cost.length) {
            if(i + 1 == cost.length) {
                minCost += cost[i];
                break;
            }

            if(cost[i] < cost[i + 1])
                minCost += cost[i++];
            else {
                minCost += cost[i + 1];
                i += 2;
            }
        }

        return minCost;
    }
}
