package com.csmarton.hackerrank.algorithms.daily.day6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    private final ThreeSum solution = new ThreeSum();

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testThreeSum(int[] nums, List<List<Integer>> expected) {
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 1, 2, -1, -4}, List.of(List.of(-1, -1, 2), List.of(-1, 0, 1))),
                Arguments.of(new int[]{0, 1, 1}, List.of()), // No valid triplets
                Arguments.of(new int[]{0, 0, 0}, List.of(List.of(0, 0, 0))) // Single valid triplet
        );
    }
}
