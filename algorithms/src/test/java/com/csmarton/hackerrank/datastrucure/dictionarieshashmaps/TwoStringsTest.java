package com.csmarton.hackerrank.datastrucure.dictionarieshashmaps;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TwoStringsTest {
    TwoStrings twoStrings = new TwoStrings();

    private Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of("", "", true)
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(String firstText, String secondText, boolean expectedResult) {
        boolean matchedSubString = twoStrings.solution(firstText, secondText);

        assertEquals(expectedResult, matchedSubString);
    }

}