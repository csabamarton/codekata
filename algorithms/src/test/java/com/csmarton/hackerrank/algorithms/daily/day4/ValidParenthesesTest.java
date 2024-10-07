package com.csmarton.hackerrank.algorithms.daily.day4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    private final ValidParentheses solution = new ValidParentheses();

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testValidParentheses(String s, boolean expected) {
        boolean result = solution.isValid(s);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false),
                Arguments.of("([)]", false),
                Arguments.of("{[]}", true),
                Arguments.of("", true), // empty string is valid
                Arguments.of("{[()()]}", true),
                Arguments.of("(", false), // unclosed bracket
                Arguments.of(")", false)  // closing without an opening
        );
    }
}
