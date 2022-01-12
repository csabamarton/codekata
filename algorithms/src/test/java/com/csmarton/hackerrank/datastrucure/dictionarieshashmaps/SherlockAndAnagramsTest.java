package com.csmarton.hackerrank.datastrucure.dictionarieshashmaps;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SherlockAndAnagramsTest {
    SherlockAndAnagrams sherlockAndAnagrams = new SherlockAndAnagrams();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of("ifailuhkqq", 3),
                Arguments.of("kkkk", 10),
                Arguments.of("abba", 4),
                Arguments.of("abcd", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(String s, int expectedNumOfAnagrams) {
        int result = sherlockAndAnagrams.solution(s);

        assertEquals(expectedNumOfAnagrams, result);
    }
}