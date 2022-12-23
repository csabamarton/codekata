package com.csmarton.hackerrank.algorithms.leetcode.easy.removeadjecent;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    private final RemoveDuplicates removeDuplicates = new RemoveDuplicates();

    static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of("abbaca", "ca")
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testRemoveDuplicates(String input, String expectedResult)
    {
        String result = removeDuplicates.removeDuplicates(input);

        assertEquals(expectedResult, result);
    }

}