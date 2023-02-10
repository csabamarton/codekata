package com.csmarton.hackerrank.algorithms.leetcode.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MoveZerosTest {

    private final MoveZeros moveZeros = new MoveZeros();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    void testMovingZeros(int[] inputArray, int[] expectedResult) {
        moveZeros.moveZeroes(inputArray);

        assertArrayEquals(expectedResult, inputArray);
    }
}