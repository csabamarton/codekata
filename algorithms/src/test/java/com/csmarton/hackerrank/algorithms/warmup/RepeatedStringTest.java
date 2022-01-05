package com.csmarton.hackerrank.algorithms.warmup;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedStringTest {
    RepeatedString repeatedString = new RepeatedString();

    public static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of("", 2)
        );
    }

    public void testSolution(String text, long expectedNumOfOccurence) {
        long result = repeatedString.solution(text);

        assertEquals(expectedNumOfOccurence, result);
    }
}