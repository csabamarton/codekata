package com.csmarton.hackerrank.algorithms.leetcode.easy.palindrome;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeTest {
    private final LongestPalindrome longestPalindrome = new LongestPalindrome();

    static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of("bb", 2),
                Arguments.of("abccccdd", 7)
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testLongestPalindrome(String input, int expectedResult)
    {
        int result = longestPalindrome.longestPalindrome(input);

        assertEquals(expectedResult, result);
    }
}