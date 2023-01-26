package com.csmarton.hackerrank.algorithms.leetcode.easy.palindrome;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

class PalindromeNumberTest {

    PalindromeNumber palindromeNumber = new PalindromeNumber();

    static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(121, true),
                Arguments.of(-121, false),
                Arguments.of(1221, true),
                Arguments.of(321, false),
                Arguments.of(32123, true),
                Arguments.of(0, true)
                );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testPalindrome(int inputNumber, boolean expectedResult)
    {
        boolean result = palindromeNumber.isPalindrome(inputNumber);

        assertEquals(expectedResult, result);
    }

}