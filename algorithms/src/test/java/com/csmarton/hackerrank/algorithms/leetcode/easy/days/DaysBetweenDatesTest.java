package com.csmarton.hackerrank.algorithms.leetcode.easy.days;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DaysBetweenDatesTest {

    DaysBetweenDates daysBetweenDates = new DaysBetweenDates();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of("2019-06-29", "2019-06-30", 1),
                Arguments.of("2020-01-15", "2019-12-31", 15)
                );
    }

    @Test
    @ParameterizedTest
    @MethodSource("paramProvider")
    void test(String date1, String date2, int expectedResult) {
        int result = daysBetweenDates.daysBetweenDates(date1, date2);

        assertEquals(expectedResult, result);
    }
}