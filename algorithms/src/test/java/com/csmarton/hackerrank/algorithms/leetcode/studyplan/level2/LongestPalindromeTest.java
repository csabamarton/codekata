package com.csmarton.hackerrank.algorithms.leetcode.studyplan.level2;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeTest {

    private final LongestPalindrome longestPalindrome = new LongestPalindrome();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new String[]{"cc","ll","xx"}, 2),
                Arguments.of(new String[]{"ab","ty","yt","lc","cl","ab"}, 8),
                Arguments.of(new String[]{"bb", "bb"}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    @Test
    void testLongestPalindrome(String[] input, int expectedResult) {
        int result = longestPalindrome.longestPalindrome(input);

        assertEquals(expectedResult, result);
    }
}