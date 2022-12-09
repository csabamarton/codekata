package com.csmarton.hackerrank.algorithms.leetcode.easy.validparentheses;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    private ValidParentheses validParentheses = new ValidParentheses();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of("(){}}{", false),
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false)
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    void testValidateParentheses(String input, boolean expectedResult) {
        boolean result = validParentheses.isValid(input);

        assertEquals(expectedResult, result);
    }
}