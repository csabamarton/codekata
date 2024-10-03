package com.csmarton.hackerrank.algorithms.daily.day1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    private final TwoSum twoSum = new TwoSum();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0,1})
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void test(int[] numbers, int target, int[] expectedResult) {
        int[] result = twoSum.solve(numbers, target);

        assertArrayEquals(expectedResult, result);
    }
}
