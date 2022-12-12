package com.csmarton.hackerrank.algorithms.leetcode.easy.climbingstairs;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {
    private final ClimbingStairs climbingStairs = new ClimbingStairs();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(3, 3),
                Arguments.of(5,8),
                Arguments.of(7,21)
                //Arguments.of(45, 1836311903)
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    void test(int numOfStairs, int expectedNumOfWays) {
        int result = climbingStairs.climbingStairs(numOfStairs);

        assertEquals(expectedNumOfWays, result);
    }
}