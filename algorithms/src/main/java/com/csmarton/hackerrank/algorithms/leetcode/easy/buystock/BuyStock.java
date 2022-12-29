package com.csmarton.hackerrank.algorithms.leetcode.easy.buystock;

public class BuyStock {

    /*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     */

    public int calMaximumPossibleProfit(int[] prices) {
        int base = prices[0];

        int diff = 0;


        for (int i = 1; i < prices.length; i++) {
            if(prices[i] - base > diff) {
                diff = prices[i] - base;
            }
            if(base > prices[i])
                base = prices[i];
        }

        return diff;
    }








    public int calMaximumPossibleProfit2(int[] prices) {
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
