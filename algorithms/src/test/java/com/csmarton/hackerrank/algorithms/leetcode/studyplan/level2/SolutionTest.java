package com.csmarton.hackerrank.algorithms.leetcode.studyplan.level2;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of("{[()]}", true),
                Arguments.of("{[()]", false)
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    void test(String input, boolean expectedResult) {

        boolean result = solution.isValid(input);

        assertEquals(expectedResult, result);
    }
}