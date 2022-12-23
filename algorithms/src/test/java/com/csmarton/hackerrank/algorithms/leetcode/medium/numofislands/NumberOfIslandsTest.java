package com.csmarton.hackerrank.algorithms.leetcode.medium.numofislands;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfIslandsTest {

    private final NumberOfIslands numberOfIslands = new NumberOfIslands();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new char[][]{
                        {'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}
                }, 1)
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    void testIslandFinder(char[][] input, int expectedResult) {
        int result = numberOfIslands.numIslands(input);

        assertEquals(expectedResult, result);
    }

}