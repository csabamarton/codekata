package com.csmarton.hackerrank.algorithms.daily.day5;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if(price < minPrice)
                minPrice = price;
            if (price - minPrice > maxProfit)
                maxProfit = price - minPrice;
        }

        return maxProfit;
    }
}
