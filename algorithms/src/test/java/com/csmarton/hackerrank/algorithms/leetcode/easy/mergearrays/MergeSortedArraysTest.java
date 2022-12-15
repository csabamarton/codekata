package com.csmarton.hackerrank.algorithms.leetcode.easy.mergearrays;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArraysTest {

    MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();

    static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new int[]{3,4,0,0},2, new int[]{5,6}, 2, new int[]{3,4,5,6}),
                Arguments.of(new int[]{5,6,0,0},2, new int[]{3,4}, 2, new int[]{3,4,5,6}),
                Arguments.of(new int[]{0},0, new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{1,2,3,0},3, new int[]{6}, 1, new int[]{1,2,3,6}),
                Arguments.of(new int[]{1,2,3,0,0,0},3, new int[]{2,5,6}, 3, new int[]{1,2,2,3,5,6})
        );
    }

    /*

    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
     */

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testMerging(int[] inputNum1, int m, int[] inputNum2, int n, int[] expectedResult)
    {
        mergeSortedArrays.merge2(inputNum1, m, inputNum2, n);

        assertArrayEquals(expectedResult, inputNum1);
    }
}