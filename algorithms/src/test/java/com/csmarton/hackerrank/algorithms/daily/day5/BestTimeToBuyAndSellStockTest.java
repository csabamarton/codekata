package com.csmarton.hackerrank.algorithms.daily.day5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStockTest {

    private final BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testMaxProfit(int[] prices, int expected) {
        int result = solution.maxProfit(prices);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 4),
                Arguments.of(new int[]{2, 4, 1}, 2),
                Arguments.of(new int[]{}, 0) // Edge case: empty array
        );
    }
}
