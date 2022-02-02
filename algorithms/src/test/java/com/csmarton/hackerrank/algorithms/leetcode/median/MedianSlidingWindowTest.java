package com.csmarton.hackerrank.algorithms.leetcode.median;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MedianSlidingWindowTest {
    MedianSlidingWindow medianSlidingWindow = new MedianSlidingWindow();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new int[]{1,3,-1,-3,5,3,6,7}, 3, new double[]{1 ,-1 ,-1 ,3 ,5 ,6})
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(int[] nums, int windowSize, double[] expetedMedians) {
        double[] medians = medianSlidingWindow.soultion(nums, windowSize);

        assertArrayEquals(expetedMedians, medians);
    }
}