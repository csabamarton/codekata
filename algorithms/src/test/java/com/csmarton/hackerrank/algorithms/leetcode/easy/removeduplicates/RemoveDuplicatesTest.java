package com.csmarton.hackerrank.algorithms.leetcode.easy.removeduplicates;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    private RemoveDuplicates removeDuplicates = new RemoveDuplicates();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new int[]{0,0,1,1,1,2,2,3,3,4}, new int[]{0,1,2,3,4,0,2,1,3,1}, 5),
                Arguments.of(new int[]{1,1,2}, new int[]{1,2,1}, 2)
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    void testRemoveDuplicates(int[] input, int[] expectedResultArray, int expectedResult) {
        int result = removeDuplicates.removeDuplicates(input);

        assertEquals(expectedResult, result);
        assertArrayEquals(expectedResultArray, input);
    }

}