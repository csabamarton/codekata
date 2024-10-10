package com.csmarton.hackerrank.algorithms.daily.day5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharactersTest {

    private final LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testLengthOfLongestSubstring(String s, int expected) {
        int result = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("", 0),
                Arguments.of(" ", 1),
                Arguments.of("au", 2),
                Arguments.of("dvdf", 3)
        );
    }
}
