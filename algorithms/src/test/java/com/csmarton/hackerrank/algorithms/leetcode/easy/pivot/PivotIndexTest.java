package com.csmarton.hackerrank.algorithms.leetcode.easy.pivot;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PivotIndexTest {
    private final PivotIndex pivotIndex = new PivotIndex();

    static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 7, 3, 6, 5, 6}, 3)
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testPivotIndex(int[] input, int expectedResult)
    {
        int result = pivotIndex.pivotIndex(input);

        assertEquals(expectedResult, result);
    }
}