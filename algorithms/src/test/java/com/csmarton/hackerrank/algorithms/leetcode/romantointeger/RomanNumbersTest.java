package com.csmarton.hackerrank.algorithms.leetcode.romantointeger;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumbersTest {

    RomanNumbers romanNumbers = new RomanNumbers();
    RomanNumberConverter romanNumberConverter = new RomanNumberConverter();

    public static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of("CMLXXVI", 976),
                Arguments.of("MCMXCIV", 1994),
                Arguments.of("LVIII", 58),
                Arguments.of("III", 3),
                Arguments.of("DCCII", 702),
                Arguments.of("DCACII", 702)
        );
    }

    @Test
    @ParameterizedTest()
    @MethodSource("paramProvider")
    void testRomanNumbersConverter(String input, int expectedNumber) {
        //int resultNumber = romanNumbers.convertRomanToInt(input);
        int resultNumberWithEnumConverter = romanNumberConverter.convertRomanToInt(input);

       // assertEquals(expectedNumber, resultNumber);
        assertEquals(expectedNumber, resultNumberWithEnumConverter);
    }

}