package com.csmarton.hackerrank.algorithms.leetcode.easy.plusone;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PlusOneTest {

    PlusOne plusOne = new PlusOne();

    private static Stream<Arguments> paramProviderForConverter() {
        return Stream.of(
                Arguments.of(1234, new int[]{1,2,3,4}),
                Arguments.of(9986, new int[]{9,9,8,6})
        );
    }

    private static Stream<Arguments> paramProviderForPlusOne() {
        return Stream.of(
                Arguments.of(new int[]{6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3}, new int[]{6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,4}),
                Arguments.of(new int[]{9,8,7,6,5,4,3,2,1,0}, new int[]{9,8,7,6,5,4,3,2,1,1}),
                Arguments.of(new int[]{1}, new int[]{2}),
                Arguments.of(new int[]{4,3,2,1}, new int[]{4,3,2,2})
        );
    }

    private static Stream<Arguments> paramProviderForDigitsToIntConverter() {
        return Stream.of(
                Arguments.of(new int[]{9}, 9),
                Arguments.of(new int[]{1,2,3,4}, 1234),
                Arguments.of(new int[]{9,9,8,6}, 9986)
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProviderForConverter")
    void testIntegerConverterToDigit(int value, int[] expectedDigits) {
        int[] resultDigits = plusOne.convertIntegerToDigits(value);

        assertArrayEquals(expectedDigits, resultDigits);
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProviderForPlusOne")
    void testIntegerConverterToDigit(int[] inputDigits, int[] expectedDigits) {
        int[] resultDigits = plusOne.plusOne(inputDigits);

        assertArrayEquals(expectedDigits, resultDigits);
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProviderForDigitsToIntConverter")
    void testDigitsToIntConverter(int[] inputDigits, double expectedValue) {
        double resultValue = plusOne.convertDigitsToInt(inputDigits);

        assertEquals(expectedValue, resultValue);
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProviderForPlusOne")
    void testIntegerConverterToDigit2(int[] inputDigits, int[] expectedDigits) {
        int[] resultDigits = plusOne.plusOne2(inputDigits);

        assertArrayEquals(expectedDigits, resultDigits);
    }
}