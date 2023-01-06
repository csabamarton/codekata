package com.csmarton.hackerrank.algorithms.leetcode.medium;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestRepeatingCharTest {

    private final LongestRepeatingChar longestRepeatingChar = new LongestRepeatingChar();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of("ABAB", 2, 4)
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    void testFindingLongestRepeatingCharacter(String input, int k, int expectedResult) {
        int result = longestRepeatingChar.characterReplacement(input, k);

        assertEquals(expectedResult, result);
    }
}