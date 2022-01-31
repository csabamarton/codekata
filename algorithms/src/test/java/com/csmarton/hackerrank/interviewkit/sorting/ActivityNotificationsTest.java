package com.csmarton.hackerrank.interviewkit.sorting;

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

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

class ActivityNotificationsTest {
    ActivityNotifications activityNotifications = new ActivityNotifications();

    private static Stream<Arguments> paramProvider() throws IOException {
        return Stream.of(
                createArguments("fraud/input3", 926),
                createArguments("fraud/input2", 492),
               createArguments("fraud/input1", 770),
                Arguments.of(Stream.of(60, 20, 100, 30, 10).collect(Collectors.toList()), 3, 0),
                Arguments.of(Stream.of(10, 20, 30, 40, 50).collect(Collectors.toList()), 3, 1),
                Arguments.of(Stream.of(2, 3, 4, 2, 3, 6, 8, 4, 5).collect(Collectors.toList()), 5, 2)
        );
    }

    private static Arguments createArguments(String testFileName, int expectedResult) throws IOException {
        Path workingDir = Path.of("", "src/test/resources");
        Path file = workingDir.resolve(testFileName);

        BufferedReader reader = new BufferedReader(new FileReader(file.toString()));

        BufferedReader bufferedReader = reader;
        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        int r = Integer.parseInt(nr[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        bufferedReader.close();

        return Arguments.of(arr, r, expectedResult);
    }

    @ParameterizedTest
    @MethodSource("paramProvider")
    public void testSolution(List<Integer> expenditure, int days, int expectedNumOfNotice) {
        int result = activityNotifications.solution2(expenditure, days);

        assertEquals(expectedNumOfNotice, result);
    }
}