package com.csmarton.hackerrank.algorithms.basic.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MinimumWindowSubstringTest {

    private final MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of("ADOBECODEBANC", "ABC", "")
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testMinimumWindowSubstring(String s, String t, String expected) {
        String result = minimumWindowSubstring.findMinimumSubstring(s, t);

        assertEquals(expected, result);
    }
}
