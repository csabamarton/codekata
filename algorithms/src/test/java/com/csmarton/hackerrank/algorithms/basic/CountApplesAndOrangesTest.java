package com.csmarton.hackerrank.algorithms.basic;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountApplesAndOrangesTest {

    CountApplesAndOranges countApplesAndOranges = new CountApplesAndOranges();

    static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new Object[] {7, 11, 5, 15, new int[] {-2, 2, 1} , new int[] {5, -6}, 1, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void solution(int s, int t, int a, int b, int[] apples, int[] oranges, int applesExpeted, int orangesExpected) {
        long[] result = countApplesAndOranges.countApplesAndOranges(s, t, a, b, apples, oranges);

        assertEquals(result[0], applesExpeted);
        assertEquals(result[1], orangesExpected);
    }
}