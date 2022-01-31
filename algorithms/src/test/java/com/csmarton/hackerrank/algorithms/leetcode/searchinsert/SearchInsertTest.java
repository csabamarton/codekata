package com.csmarton.hackerrank.algorithms.leetcode.searchinsert;

import com.csmarton.hackerrank.interviewkit.sorting.ActivityNotifications;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

class SearchInsertTest {
    SearchInsert searchInsert = new SearchInsert();

    private static Stream<Arguments> paramProvider() throws IOException {
        return Stream.of(

               // Arguments.of(new int[]{1, 3, 5, 6}, 3, 1),
              //  Arguments.of(new int[]{1, 3, 5, 6}, 5, 2),
                Arguments.of(new int[]{2, 7, 8, 9, 10}, 9, 3),
                Arguments.of(new int[]{1, 3}, 1, 0),
                Arguments.of(new int[]{1, 3, 5, 6}, 7, 4),
                Arguments.of(new int[]{1, 3, 6, 9, 11}, 4, 2)
        );
    }


    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(int[] nums, int target, int expectedIndex) {
        int result = searchInsert.solution2(nums, target);

        assertEquals(expectedIndex, result);
    }

}