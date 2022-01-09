package com.csmarton.hackerrank.datastrucure.dictionarieshashmaps;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CheckMagazineTest {
    CheckMagazine checkMagazine = new CheckMagazine();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(List.of("give", "me", "one", "grand", "today", "night"),
                        List.of("give", "one", "grand", "today"), true),
                Arguments.of(List.of("two","times","three","is","not","four") ,
                        List.of("two","times","two","is","four"), false),
                Arguments.of(List.of("two","two") ,
                        List.of("two","two"), true)
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(List<String> magazine, List<String> note, boolean expectedResult) {
        boolean result = checkMagazine.solution(magazine, note);

        assertEquals(expectedResult, result);

    }
}