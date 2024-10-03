package com.csmarton.hackerrank.algorithms.daily.day1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {

    private final ValidAnagram validAnagram = new ValidAnagram();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of("anagram", "nagaram", true),
                Arguments.of("rat", "car", false),
                Arguments.of("a", "a", true),
                Arguments.of("abc", "def", false),
                Arguments.of("", "", true),
                Arguments.of(" ", " ", true),
                Arguments.of("aabbcc", "ccbbaa", true),
                Arguments.of("anagram!", "nagaram!", true),
                Arguments.of("Hello!", "hello!", false)
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void test(String s, String t, boolean expectedResult) {
        boolean result = validAnagram.solve(s, t);

        assertEquals(expectedResult, result);
    }
}
