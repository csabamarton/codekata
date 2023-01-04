package com.csmarton.hackerrank.algorithms.leetcode.easy.dynamicprogramming;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MinCostClimbingTest {

    private final MinCostClimbing minCostClimbing = new MinCostClimbing();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new int[]{10,15,20}, 15),
                Arguments.of(new int[]{0,0,1,1}, 1)
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    void test(int[] input, int expectedResult) {
        int result = minCostClimbing.minCostClimbingStairsDP(input);

        assertEquals(expectedResult, result);
    }
}