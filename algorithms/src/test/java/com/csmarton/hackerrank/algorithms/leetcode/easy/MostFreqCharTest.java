package com.csmarton.hackerrank.algorithms.leetcode.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MostFreqCharTest {

    private final MostFreqChar mostFreqChar = new MostFreqChar();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of("hhzzzzaaa", 'z'),
                Arguments.of("hhzzzzaaaaa", 'a')
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    void testFindingMostFreqCharacter(String input, char expectedChar) {
        char result = mostFreqChar.findMostFrequentChar(input);

        assertEquals(expectedChar, result);
    }
}