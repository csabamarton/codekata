package com.csmarton.hackerrank.algorithms.leetcode.easy.buystock;

public class BuyStock {
    public int calMaximumPossibleProfit(int[] prices) {
        int base = prices[0];
        int diff = 0;

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];

            if (price > base) {
                if (diff < price - base)
                    diff = price - base;
            } else {
                base = price;
            }
        }

        return diff;
    }
}
