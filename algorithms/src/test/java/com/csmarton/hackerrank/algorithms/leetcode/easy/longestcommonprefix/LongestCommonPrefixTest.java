package com.csmarton.hackerrank.algorithms.leetcode.easy.longestcommonprefix;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

    static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new String[]{"a"}, "a"),
                Arguments.of(new String[]{""}, ""),
                Arguments.of(new String[]{"flower","flow","flight"}, "fl"),
                Arguments.of(new String[]{"dog","racecar","car"}, ""));
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    void testLongestCommonPrefixFinder(String[] input, String expectedResult) {
        String result = longestCommonPrefix.longestCommonPrefix(input);

        assertEquals(expectedResult, result);
    }

}