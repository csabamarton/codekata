package com.csmarton.hackerrank.algorithms.daily.day3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    private final RemoveDuplicates removeDuplicates = new RemoveDuplicates();

    // Helper method to truncate the array to the first k elements (since after k, the values are irrelevant)
    private int[] truncateArray(int[] array, int length) {
        int[] truncated = new int[length];
        System.arraycopy(array, 0, truncated, 0, length);
        return truncated;
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 5, new int[]{0, 1, 2, 3, 4}),
                Arguments.of(new int[]{}, 0, new int[]{}),
                Arguments.of(new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1}, 1, new int[]{1})
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testRemoveDuplicates(int[] nums, int expectedLength, int[] expectedArray) {
        int resultLength = removeDuplicates.removeDuplicates(nums);

        assertEquals(expectedLength, resultLength, "The length of the array after removing duplicates should be correct.");
        assertArrayEquals(expectedArray, truncateArray(nums, resultLength), "The array should match the expected unique elements.");
    }

}

