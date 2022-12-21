package com.csmarton.hackerrank.algorithms.leetcode.easy.pascaltriangle;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PascalsTriangleTest {

    private final PascalsTriangle pascalsTriangle = new PascalsTriangle();

    static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(5,List.of(List.of(1),List.of(1,1),List.of(1,2,1),List.of(1,3,3,1),List.of(1,4,6,4,1)))
        );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testPascalsTriangle(int inputNumber, List<List<Integer>> expectedResult)
    {
        List<List<Integer>> result = pascalsTriangle.generate(inputNumber);

        assertEquals(expectedResult, result);
    }

}