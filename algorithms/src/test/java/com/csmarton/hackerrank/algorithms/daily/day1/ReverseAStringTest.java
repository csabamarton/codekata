package com.csmarton.hackerrank.algorithms.daily.day1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ReverseAStringTest {

    private final ReverseAString reverseAString = new ReverseAString();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new char[]{'h','e','l','l','o'}, new char[]{'o','l','l','e','h'}),
                Arguments.of(new char[]{'H','a','n','n','a','h'}, new char[]{'h','a','n','n','a','H'})
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void test(char[] input, char[] expected) {
        char[] result = reverseAString.solve(input);

        assertArrayEquals(expected, result);
    }
}
