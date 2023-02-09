package com.csmarton.hackerrank.algorithms.leetcode.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DeleteNotSortedColumnsTest {

    private final DeleteNotSortedColumns deleteNotSortedColumns = new DeleteNotSortedColumns();

    private static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of(new String[]{"a", "b"}, 0),
                Arguments.of(new String[]{"abc", "bce", "cae"}, 1),
                Arguments.of(new String[]{"cba","daf","ghi"}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    void testColoumnDeletion(String[] input, int expectedResult) {
        int result = deleteNotSortedColumns.minDeletionSize(input);

        assertEquals(expectedResult, result);
    }

}