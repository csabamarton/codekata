package com.csmarton.hackerrank.algorithms.leetcode.easy.addbinary;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AddBinaryTest {
    private final AddBinary addBinary = new AddBinary();

    private static Stream<Arguments> paramProviderForAddingBinary() {
        return Stream.of(
                Arguments.of("100", "110010", "110110"),
                Arguments.of("11", "1", "100"),
                Arguments.of("1010", "1011", "10101")
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProviderForAddingBinary")
    void testAddingBinaryNumbers(String aInput, String bInput, String expectedResult) {
        String result = addBinary.addBinary(aInput, bInput);

        assertEquals(expectedResult, result);
    }
}