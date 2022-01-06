package com.csmarton.hackerrank.datastrucure.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MinimumBribesTest {
    MinimumBribes minimumBribes = new MinimumBribes();

    public static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(List.of(), true)
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(List<Integer> inititalQueue, boolean expectedResult) {
        boolean result = minimumBribes.solution(inititalQueue);

        assertEquals(expectedResult, result);
    }

}