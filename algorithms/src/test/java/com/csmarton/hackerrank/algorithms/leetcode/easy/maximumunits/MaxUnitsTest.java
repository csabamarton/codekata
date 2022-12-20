package com.csmarton.hackerrank.algorithms.leetcode.easy.maximumunits;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MaxUnitsTest {
    private final MaxUnits maxUnits = new MaxUnits();

    static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1,3}, {2,2}, {3,1}}, 4, 8),
                Arguments.of(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10, 91)
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    void testMaxUnits(int[][] boxTypes, int truckSize, int expectedResult) {
        int result = maxUnits.maximumUnits(boxTypes, truckSize);

        assertEquals(expectedResult, result);
    }
}