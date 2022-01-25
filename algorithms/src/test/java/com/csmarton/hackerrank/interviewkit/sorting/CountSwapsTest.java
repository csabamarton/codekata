package com.csmarton.hackerrank.interviewkit.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CountSwapsTest {
    CountSwaps countSwaps = new CountSwaps();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(List.of(6, 4, 1), List.of(3, 1, 6))
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(List<Integer> initialList, List<Integer> expectedResults) {
        List<Integer> result = countSwaps.solution(initialList);

        assertNotNull(result);
        assertTrue(result.size() == 3);
        assertArrayEquals(expectedResults.toArray(), result.toArray());
    }

}