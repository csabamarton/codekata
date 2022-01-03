package com.csmarton.hackerrank.algorithms.warmup;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MatchingSocksTest {
    MatchingSocks matchingSocks = new MatchingSocks();

    public static Stream<Arguments> parameterInputs() {
        return Stream.of(
                Arguments.of(new Object[] {new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("parameterInputs")
    public void testSolution(int[] paramArray, int numOfExpectedPairs) {
        int result = matchingSocks.solution(paramArray);

        assertEquals(numOfExpectedPairs, result);
    }

}