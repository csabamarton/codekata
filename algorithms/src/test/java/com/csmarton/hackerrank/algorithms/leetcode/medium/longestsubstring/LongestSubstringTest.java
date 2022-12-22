package com.csmarton.hackerrank.algorithms.leetcode.medium.longestsubstring;

import com.csmarton.hackerrank.algorithms.leetcode.easy.longestcommonprefix.LongestCommonPrefix;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringTest {
    LongestSubstring longestSubstring = new LongestSubstring();

    static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of("abba", 2),
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3));
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    void testLongestCommonPrefixFinder(String input, int expectedResult) {
        int result = longestSubstring.lengthOfLongestSubstring(input);

        assertEquals(expectedResult, result);
    }
}