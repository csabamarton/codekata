package com.csmarton.hackerrank.algorithms.warmup;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CountingValleysTest {
    CountingValleys countingValleys = new CountingValleys();

    public static Stream<Arguments> paramsProvider() {
        return Stream.of(
                Arguments.of(new Object[] {8, "UDDDUDUU", 1})
        );
    }

    @ParameterizedTest
    @MethodSource("paramsProvider")
    public void testSolution(int steps, String path, int expectedNumOfValleys) {
        int result = countingValleys.solve(steps, path);

        assertEquals(result, expectedNumOfValleys);
    }
}