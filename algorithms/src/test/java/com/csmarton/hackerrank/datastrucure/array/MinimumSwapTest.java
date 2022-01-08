package com.csmarton.hackerrank.datastrucure.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MinimumSwapTest {
    MinimumSwap minimumSwap = new MinimumSwap();

    public static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new int[] {2, 3, 4, 1, 5}, 3),
                Arguments.of(new int[] {1, 3, 5, 2, 4, 6, 7}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(int[] arr, int expectedMinSwap) {
        int result = minimumSwap.solution(arr);

        assertEquals(expectedMinSwap, result);
    }
}