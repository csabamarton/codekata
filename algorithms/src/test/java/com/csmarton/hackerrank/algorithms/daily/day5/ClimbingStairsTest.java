package com.csmarton.hackerrank.algorithms.daily.day5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {

    private final ClimbingStairs solution = new ClimbingStairs();

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testClimbingStairs(int n, int expected) {
        int result = solution.climbStairs(n);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(2, 2),   // 2 ways
                Arguments.of(3, 3),   // 3 ways
                Arguments.of(4, 5),   // 5 ways
                Arguments.of(5, 8),   // 8 ways (Fibonacci-like)
                Arguments.of(1, 1)    // 1 way for 1 step
        );
    }
}
