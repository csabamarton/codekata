package com.csmarton.hackerrank.algorithms.leetcode.easy.binarysearch;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private final BinarySearch binarySearch = new BinarySearch();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new int[]{2,5}, 2, 0),
                Arguments.of(new int[]{-1,0,3,5,9,12}, 9, 4),
                Arguments.of(new int[]{-1,0,3,5,9,12}, 2, -1)
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    void testBinarySearch(int[] input, int target, int expectedIndex) {
        int result = binarySearch.search(input, target);

        assertEquals(expectedIndex, result);
    }
}