package com.csmarton.hackerrank.algorithms.leetcode.easy.buystock;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

class BuyStockTest {
    private final BuyStock buyStock = new BuyStock();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new int[]{7,1,5,3,6,4}, 5)
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    void test(int[] inputPrices, int expectedResult) {
        int result = buyStock.calMaximumPossibleProfit(inputPrices);

        assertEquals(expectedResult, result);
    }
}