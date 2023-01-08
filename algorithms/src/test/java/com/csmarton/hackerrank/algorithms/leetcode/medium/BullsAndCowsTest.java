package com.csmarton.hackerrank.algorithms.leetcode.medium;

import com.csmarton.hackerrank.algorithms.leetcode.addtwonumbers.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BullsAndCowsTest {

    private final BullsAndCows bullsAndCows = new BullsAndCows();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of("1122", "1222", "3A0B"),

                /*
                Input: secret = "1123", guess = "0111"
                Output: "1A1B"
                 */
                Arguments.of("1123", "0111", "1A1B"),
                Arguments.of("1807", "7810", "1A3B")

        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(String secret, String guess, String expectedResult) {
        String result = bullsAndCows.getHint(secret, guess);

        assertEquals(expectedResult, result);
    }

}