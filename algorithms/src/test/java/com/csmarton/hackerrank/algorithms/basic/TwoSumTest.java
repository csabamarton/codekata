package com.csmarton.hackerrank.algorithms.basic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {
    TwoSum twoSum = new TwoSum();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new int[]{3,2,4}, 6, new int[]{1,2}),
                Arguments.of(new int[]{2,7,11,15}, 9, new int[]{0,1})
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(int[] numbers, int target, int[] expectedPair) {
        int[] result = twoSum.solution(numbers, target);

        assertArrayEquals(expectedPair, result);
    }

}