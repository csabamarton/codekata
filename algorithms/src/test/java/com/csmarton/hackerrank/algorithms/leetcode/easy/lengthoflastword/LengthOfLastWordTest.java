package com.csmarton.hackerrank.algorithms.leetcode.easy.lengthoflastword;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLastWordTest {
    private LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of("Hello World", 5),
                Arguments.of("   fly me   to   the moon  ", 4),
                Arguments.of("luffy is still joyboy", 6)
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    void testFindingLengthOfLastWord(String input, int expectedLenght) {
        int result = lengthOfLastWord.solution(input);

        assertEquals(expectedLenght, result);
    }
}