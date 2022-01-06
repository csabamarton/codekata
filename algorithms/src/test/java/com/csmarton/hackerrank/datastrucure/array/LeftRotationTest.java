package com.csmarton.hackerrank.datastrucure.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LeftRotationTest {
    LeftRotation leftRotation = new LeftRotation();

    public static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(List.of(1,2,3), 2, List.of(2,3,1))
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(List<Integer> initialList, int numOfRotation, List<Integer> afterRotationList) {
        List<Integer> result = leftRotation.solution(initialList, numOfRotation);

        assertIterableEquals(afterRotationList, result);
    }
}