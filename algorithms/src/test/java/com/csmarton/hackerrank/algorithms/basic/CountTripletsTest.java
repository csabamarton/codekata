package com.csmarton.hackerrank.algorithms.basic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CountTripletsTest {
    CountTriplets countTriplets = new CountTriplets();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 5, 1, 5, 25, 125), 5, 5),
                //Arguments.of(List.of(1,4, 16, 64), 4, 2),
                //Arguments.of(List.of(1,2,2,4), 2, 2),
                //Arguments.of(List.of(1, 3, 9, 9, 27, 81), 3, 6),
                Arguments.of(List.of(1, 1, 1, 1), 1, 4),
                Arguments.of(List.of(1, 1, 1, 1, 1), 1, 4),
                Arguments.of(List.of(1, 1, 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), 1, 4),
                Arguments.of(List.of(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                        1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1), 1, 161700)
                );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(List<Long> numbers, long ratio, long expectedNumOfTriplets) {
        long result = countTriplets.solution2(numbers, ratio);

        assertEquals(expectedNumOfTriplets, result);
    }

}