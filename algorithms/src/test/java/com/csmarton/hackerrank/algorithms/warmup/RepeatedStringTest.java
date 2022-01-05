package com.csmarton.hackerrank.algorithms.warmup;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedStringTest {
    RepeatedString repeatedString = new RepeatedString();

    public static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of("aba", 10, 7),
                Arguments.of("abcac", 10, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(String text, long textLength, int expectedNumOfOccurence) {
        int result = repeatedString.solution(text, textLength);

        assertEquals(expectedNumOfOccurence, result);
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution2(String text, long textLength, long expectedNumOfOccurence) {
        long result = repeatedString.solution2(text, textLength);

        assertEquals(expectedNumOfOccurence, result);
    }
}