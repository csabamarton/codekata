package com.csmarton.hackerrank.algorithms.leetcode.easy.dynamicprogramming;

public class MinCostClimbing {

    public int minCostClimbingStairsDP(int[] cost) {
        int cost1 = 0, cost2 = 0;

        for (int i = 2; i < cost.length; i++) {
            int next = Math.min(cost1 + cost[i - 2], cost2 + cost[i - 1]);

            cost1 = cost2;
            cost2 = next;
        }

        int min = Math.min(cost1 + cost[cost.length - 2], cost2 + cost[cost.length - 1]);
        return min;
    }

    int[] cost;

    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;

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

    public int minCostClimbingStairs2(int[] cost) {
        this.cost = cost;
        int minCost = 0;

        minCost = recursive(-1);

        return minCost;
    }

    private int recursive(int level) {
        if(level >= cost.length - 2)
            return cost[level];

        int oneStep = recursive(level + 1);
        int twoStep = recursive(level + 2);

        return (level < 0 ? 0 : cost[level]) + (oneStep < twoStep ? oneStep : twoStep);
    }
}

