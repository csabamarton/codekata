package com.csmarton.hackerrank.interviewkit.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MaximumToysTest {
    MaximumToys maximumToys = new MaximumToys();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(Stream.of(1, 12, 5, 111, 200, 1000, 10).collect(Collectors.toList()), 50, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(List<Integer> list, int budget, int expectedNumofToys) {
        int result = maximumToys.solution(list, budget);

        assertEquals(expectedNumofToys, result);
    }


}