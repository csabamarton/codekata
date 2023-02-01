package com.csmarton.hackerrank.algorithms.leetcode.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RotateArrayTest {

    private final RotateArray rotateArray = new RotateArray();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4,5,6}, 4, new int[]{3,4,5,6,1,2}),
                Arguments.of(new int[]{1,2,3,4,5,6,7}, 3, new int[]{5,6,7,1,2,3,4}),
                Arguments.of(new int[]{-1,-100,3,99}, 2, new int[]{3,99,-1,-100})
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    void testRotatingArray(int[] input, int k,  int[] expectedArr) {
        rotateArray.rotate(input, k);

        assertArrayEquals(expectedArr, input);

    }
}