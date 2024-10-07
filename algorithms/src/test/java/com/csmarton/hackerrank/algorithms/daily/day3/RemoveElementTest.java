package com.csmarton.hackerrank.algorithms.daily.day3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RemoveElementTest {

    private final RemoveElement solution = new RemoveElement();

    private int[] truncateArray(int[] array, int length) {
        int[] truncated = new int[length];
        System.arraycopy(array, 0, truncated, 0, length);
        return truncated;
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testRemoveElement(int[] nums, int val, int expectedLength, int[] expectedArray) {
        int resultLength = solution.removeElement(nums, val);

        assertEquals(expectedLength, resultLength, "The length of the array after removing the element should be correct.");
        assertArrayEquals(expectedArray, truncateArray(nums, resultLength), "The array should match the expected elements after removal.");
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 2, 3}, 3, 2, new int[]{2, 2}),
                Arguments.of(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, 5, new int[]{0, 1, 3, 0, 4}),
                Arguments.of(new int[]{1}, 1, 0, new int[]{}),
                Arguments.of(new int[]{}, 3, 0, new int[]{}),
                Arguments.of(new int[]{4, 5}, 5, 1, new int[]{4})
        );
    }
}
