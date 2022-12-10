package com.csmarton.hackerrank.algorithms.leetcode.easy.removeelement;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RemoveElementTest {

    private RemoveElement removeElement = new RemoveElement();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new int[]{3,3}, new int[]{3,3}, 5, 2, 2),
                Arguments.of(new int[]{3,2,2,3}, new int[]{2,2,3,3}, 3, 2, 2),
                Arguments.of(new int[]{0,1,2,2,3,0,4,2}, new int[]{0,1,4,0,3}, 2, 5, 5)
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    void testRemoveElement(int[] inputArray, int[] expectedArray,int val, int expectedResult, int sizeOfNecessaryArray) {
        int result = removeElement.removeElement(inputArray, val);

        assertEquals(expectedResult, result);

        int[] expectedArr = IntStream.range(0, sizeOfNecessaryArray)
                .map(i -> expectedArray[i])
                .toArray();
        int[] resultArr = IntStream.range(0, sizeOfNecessaryArray)
                .map(i -> expectedArray[i])
                .toArray();

        assertArrayEquals(expectedArr, resultArr);
    }

}