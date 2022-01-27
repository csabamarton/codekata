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
                Arguments.of(Stream.of(6, 4, 1).collect(Collectors.toList()), List.of("3", "1", "6"))
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(List<Integer> initialList, int k, int expectedResults) {
        int result = maximumToys.solution(initialList, k);

        assertEquals(expectedResults, result);
    }


}