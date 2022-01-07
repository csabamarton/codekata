package com.csmarton.hackerrank.datastrucure.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MinimumBribesTest {
    MinimumBribes minimumBribes = new MinimumBribes();

    public static Stream<Arguments> paramProvider() {
        return Stream.of(
                /*Arguments.of(List.of(2, 1, 5, 3, 4), 3),
                Arguments.of(List.of(2, 5, 1, 3, 4), -1),
                Arguments.of(List.of(5, 1, 2, 3, 7, 8, 6, 4), -1),
                */Arguments.of(List.of(1, 2, 5, 3, 7, 8, 6, 4), 7)
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(List<Integer> inititalQueue, int expectedResult) throws Exception {
        int result = minimumBribes.solution(new ArrayList<>(inititalQueue));

        assertEquals(expectedResult, result);
    }

}