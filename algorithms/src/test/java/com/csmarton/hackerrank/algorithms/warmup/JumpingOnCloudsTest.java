package com.csmarton.hackerrank.algorithms.warmup;

import com.google.common.collect.Lists;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class JumpingOnCloudsTest {
    JumpingOnClouds jumpingOnClouds = new JumpingOnClouds();

    public static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(List.of(0, 0, 1, 0, 0, 1, 0), 3)
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void testSolution(List<Integer> clouds, int expectedMinJumps) {
        int result = jumpingOnClouds.solution(clouds);

        assertEquals(result, expectedMinJumps);
    }
}